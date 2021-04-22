package app.onoff.cryptocurrencytracking.services;

import app.onoff.cryptocurrencytracking.dto.Exchange;
import app.onoff.cryptocurrencytracking.exception.CryptocurrencyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BitfinexService {
    @Value("${bitfinex.exchangeUrl}")
    private String URL;

    public Double getMarketValue(Exchange exchange) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Exchange> req = new HttpEntity<>(exchange);
        ResponseEntity<String[]> response;
        try {
            response = restTemplate.postForEntity(URL, req, String[].class);
        }catch (Exception e){
            throw new CryptocurrencyNotFoundException("Invalid cryptocurrency name!");
        }
        return Double.valueOf(response.getBody()[0]);
    }
}
