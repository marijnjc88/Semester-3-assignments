package nl.fontys.s3.starter.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetCheapestRequest {
    private String fromCurrency;
    private String toCurrency;
}
