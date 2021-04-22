package app.onoff.cryptocurrencytracking.services;

import app.onoff.cryptocurrencytracking.dto.Exchange;
import app.onoff.cryptocurrencytracking.entity.Cryptocurrency;
import app.onoff.cryptocurrencytracking.exception.CryptocurrencyNotFoundException;
import app.onoff.cryptocurrencytracking.repository.CryptocurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocurrencyService {
    private final CryptocurrencyRepository repository;
    private final BitfinexService service;

    public CryptocurrencyService(CryptocurrencyRepository repository, BitfinexService service) {
        this.repository = repository;
        this.service = service;
    }

    public void save(Cryptocurrency cryptocurrency) {
        Double marketValue = service.getMarketValue(new Exchange(cryptocurrency.getName(), "EUR"));
        cryptocurrency.setMarketValuePurchase(marketValue);
        repository.save(cryptocurrency);
    }

    public String deleteRecordById(Long id) {
        repository.deleteById(id);
        return "Record deleted - ID : " + id;
    }

    public void updateRecord(Cryptocurrency cryptocurrency) {
        save(cryptocurrency);
    }

    public Cryptocurrency getRecordById(Long id) {
        Cryptocurrency cryptocurrency = repository.findById(id).
                orElseThrow(() -> new CryptocurrencyNotFoundException("Cryptocurrency not found!"));
        setCurrentMarketValue(cryptocurrency);
        return cryptocurrency;
    }

    public List<Cryptocurrency> getAllRecords() {
        List<Cryptocurrency> all = repository.findAll();
        all.forEach(this::setCurrentMarketValue);
        return all;
    }

    private void setCurrentMarketValue(Cryptocurrency cryptocurrency) {
        Double marketValue = service.getMarketValue(new Exchange(cryptocurrency.getName(), "EUR"));
        cryptocurrency.setMarketValueCurrent(marketValue);
        cryptocurrency.setTradeDifference(marketValue - cryptocurrency.getMarketValuePurchase());
        cryptocurrency.setCalculatedAmount(cryptocurrency.getMarketValuePurchase() * cryptocurrency.getAmount());
    }
}
