package nl.fontys.s3.starter.persistence.impl.mockExchange;

import nl.fontys.s3.starter.domain.TickerPrice;
import nl.fontys.s3.starter.persistence.TickerPriceRepository;
import org.springframework.stereotype.Repository;

// Always returns a price of 100 000
@Repository
public class MockExchangeTickerPriceRepositoryImpl implements TickerPriceRepository {
    @Override
    public TickerPrice getCurrentPrice(String fromCurrency, String toCurrency) {
        return TickerPrice.builder()
                .exchangeName("Mock Exchange")
                .price(100000.0)
                .build();
    }
}
