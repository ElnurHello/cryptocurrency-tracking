package app.onoff.cryptocurrencytracking.exception;

public class CryptocurrencyNotFoundException extends RuntimeException {
    public CryptocurrencyNotFoundException(String s) {
        super(s);
    }
}
