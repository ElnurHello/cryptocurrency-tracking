package app.onoff.cryptocurrencytracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Exchange {
    @JsonProperty("ccy1")
    private String ccy1;
    @JsonProperty("ccy2")
    private String ccy2;
}
