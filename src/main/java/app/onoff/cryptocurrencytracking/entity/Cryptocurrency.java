package app.onoff.cryptocurrencytracking.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Cryptocurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Cryptocurrency name should not be empty")
    private String name;
    @NotNull(message = "Amount should not be empty")
    private Double amount;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime creationTime;
    @NotNull(message = "Wallet location should not be empty")
    private String walletLocation;
    @Column(nullable = false, updatable = false)
    private Double marketValuePurchase;
    @Transient
    private Double marketValueCurrent;
    @Transient
    private Double tradeDifference;
    @Transient
    private Double calculatedAmount;



}
