package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UpdateCountryUseCase;
import fontys.sem3.school.business.exception.InvalidCountryException;
import fontys.sem3.school.domain.UpdateCountryRequest;
import fontys.sem3.school.persistence.CountryRepository;
import fontys.sem3.school.persistence.entity.CountryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateCountryUseCaseImpl implements UpdateCountryUseCase {
    private final CountryRepository countryRepository;

    @Override
    public void updateCountry(UpdateCountryRequest request) {
        Optional<CountryEntity> countryOptional = countryRepository.getById(request.getId());
        if (countryOptional.isEmpty()) {
            throw new InvalidCountryException("COUNTRY_ID_INVALID");
        }

        CountryEntity country = countryOptional.get();
        updateFields(request, country);
    }

    private void updateFields(UpdateCountryRequest request, CountryEntity country) {
        country.setCode(request.getCode());
        country.setName(request.getName());

        countryRepository.save(country);
    }
}
