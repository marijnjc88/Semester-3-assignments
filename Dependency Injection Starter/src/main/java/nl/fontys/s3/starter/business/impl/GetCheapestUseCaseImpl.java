package nl.fontys.s3.starter.business.impl;

import nl.fontys.s3.starter.business.GetCheapestUseCase;
import nl.fontys.s3.starter.domain.GetCheapestRequest;
import nl.fontys.s3.starter.domain.GetCheapestResponse;
import org.springframework.stereotype.Service;
import nl.fontys.s3.starter.persistence.TickerPriceRepository;
import nl.fontys.s3.starter.domain.TickerPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GetCheapestUseCaseImpl implements GetCheapestUseCase {
    private final List<TickerPriceRepository> tickerPriceRepositories;

    public GetCheapestUseCaseImpl(List<TickerPriceRepository> tickerPriceRepositories) {
        this.tickerPriceRepositories = tickerPriceRepositories;
    }

    @Override
    public GetCheapestResponse getCheapest(GetCheapestRequest request) {
        List<TickerPrice> prices = new ArrayList<>();
        // At what index the lowest price is listed
        int index = 0;
        // What the lowest price is
        double lowest = 0;
        // Loop through all TickerPriceRepositories
        for(int i = 0; i < tickerPriceRepositories.size(); i++)
        {
            // Add the price to the prices list
            prices.add(tickerPriceRepositories.get(i).getCurrentPrice(request.getFromCurrency(), request.getToCurrency()));
            // Check if it is the lowest price
            if (lowest == 0 || prices.get(i).getPrice() < lowest) {
                // If it is the lowest price, save the index of the price in the list to index, and save the new lowest price to lowest
                lowest = prices.get(i).getPrice();
                index = i;
            }
        }

        // For all prices that aren't the lowest price, calculate the difference and add it to a list
        List<TickerPrice> difs = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            if (i != index) {
                difs.add(TickerPrice.builder()
                        .exchangeName(prices.get(i).getExchangeName())
                        .price(prices.get(i).getPrice() - lowest)
                        .build());
            }
        }

        // Return GetCheapestResponse with the necessary components
        return GetCheapestResponse.builder()
                .fromCurrency(request.getFromCurrency())
                .toCurrency(request.getToCurrency())
                .lowestPrice(prices.get(index)) // The lowest price
                .differences(Collections.unmodifiableList(difs)) // The difference with every other TickerPriceRepository
                .build();
    }
}
