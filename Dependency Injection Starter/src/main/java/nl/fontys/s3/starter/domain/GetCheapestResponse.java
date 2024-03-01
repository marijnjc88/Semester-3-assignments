package nl.fontys.s3.starter.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetCheapestResponse {
    private String fromCurrency;
    private String toCurrency;
    // The lowest price
    private TickerPrice lowestPrice;
    // The difference with every other TickerPriceRepository
    private List<TickerPrice> differences;
}
