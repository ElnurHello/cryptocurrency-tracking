package app.onoff.cryptocurrencytracking.controller;

import app.onoff.cryptocurrencytracking.entity.Cryptocurrency;
import app.onoff.cryptocurrencytracking.services.CryptocurrencyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping
    public List<Cryptocurrency> findAllRecords() {
        return cryptocurrencyService.getAllRecords();
    }

    @GetMapping("/{id}")
    public Cryptocurrency findProductById(@PathVariable Long id) {
        return cryptocurrencyService.getRecordById(id);
    }

    @PostMapping
    public void addRecord(@Valid @RequestBody Cryptocurrency cryptocurrency) {
        cryptocurrencyService.save(cryptocurrency);
    }

    @PutMapping
    public void updateRecord(@Valid @RequestBody Cryptocurrency cryptocurrency) {
        cryptocurrencyService.updateRecord(cryptocurrency);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return cryptocurrencyService.deleteRecordById(id);
    }
}
