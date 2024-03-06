package fontys.sem3.school.controller;

import fontys.sem3.school.business.GetCountriesUseCase;
import fontys.sem3.school.business.GetCountryUseCase;
import fontys.sem3.school.business.UpdateCountryUseCase;
import fontys.sem3.school.business.DeleteCountryUseCase;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.business.CreateCountryUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountriesController {
    private final GetCountriesUseCase getCountriesUseCase;
    private final CreateCountryUseCase createCountryUseCase;
    private final GetCountryUseCase getCountryUseCase;
    private final UpdateCountryUseCase updateCountryUseCase;
    private final DeleteCountryUseCase deleteCountryUseCase;

    @GetMapping
    public ResponseEntity<GetCountriesResponse> getCountries() {
        return ResponseEntity.ok(getCountriesUseCase.getCountries());
    }

    @PostMapping()
    public ResponseEntity<CreateCountryResponse> createCountry(@RequestBody @Valid CreateCountryRequest request) {
        CreateCountryResponse response = createCountryUseCase.createCountry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> getCountry(@PathVariable(value = "id") final long id) {
        final Optional<Country> countryOptional = getCountryUseCase.getCountry(id);
        if (countryOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(countryOptional.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCountry(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateCountryRequest request) {
        request.setId(id);
        updateCountryUseCase.updateCountry(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{countryId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable int countryId) {
        deleteCountryUseCase.deleteCountry(countryId);
        return ResponseEntity.noContent().build();
    }
}
