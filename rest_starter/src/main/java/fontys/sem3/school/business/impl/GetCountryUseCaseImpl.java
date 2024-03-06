package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetCountryUseCase;
import fontys.sem3.school.domain.Country;
import fontys.sem3.school.persistence.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCountryUseCaseImpl implements GetCountryUseCase {
    private CountryRepository countryRepository;

    @Override
    public Optional<Country> getCountry(long countryId) {
        return countryRepository.getById(countryId).map(CountryConverter::convert);
    }
}
