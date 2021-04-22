package app.onoff.cryptocurrencytracking.repository;

import app.onoff.cryptocurrencytracking.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
}
