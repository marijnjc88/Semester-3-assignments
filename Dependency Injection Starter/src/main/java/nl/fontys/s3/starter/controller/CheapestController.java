package nl.fontys.s3.starter.controller;

import nl.fontys.s3.starter.business.GetCheapestUseCase;
import nl.fontys.s3.starter.domain.GetCheapestRequest;
import nl.fontys.s3.starter.domain.GetCheapestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickers/cheapest")
public class CheapestController {
    private final GetCheapestUseCase getCheapestUseCase;

    public CheapestController(GetCheapestUseCase getCheapestUseCase) {
        this.getCheapestUseCase = getCheapestUseCase;
    }

    // Get Cheapest API endpoint http://localhost:8080/tickers/cheapest?from={fromCurrency}&to={toCurrency}
    // Link with filled in currencies for testing: http://localhost:8080/tickers/cheapest?from=BTC&to=EUR
    @GetMapping
    public ResponseEntity<GetCheapestResponse> getCheapest(@RequestParam("from") String fromCurrency,
                                                           @RequestParam("to") String toCurrency) {
        // Make getCheapestRequestDTO to send the request to the UseCase
        GetCheapestRequest getCheapestRequestDTO = GetCheapestRequest.builder()
                .fromCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .build();
        // Get the response from the UseCase
        GetCheapestResponse responseBody = getCheapestUseCase.getCheapest(getCheapestRequestDTO);
        // Return the response in a json file format
        return ResponseEntity.ok(responseBody);
    }
}
