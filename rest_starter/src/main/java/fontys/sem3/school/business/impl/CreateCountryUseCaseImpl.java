package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CreateCountryUseCase;
import fontys.sem3.school.business.exception.CodeAlreadyExistsException;
import fontys.sem3.school.domain.CreateCountryRequest;
import fontys.sem3.school.domain.CreateCountryResponse;
import fontys.sem3.school.persistence.CountryRepository;
import fontys.sem3.school.persistence.entity.CountryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCountryUseCaseImpl implements CreateCountryUseCase {
    private final CountryRepository countryRepository;

    @Override
    public CreateCountryResponse createCountry(CreateCountryRequest request) {
        if (countryRepository.existsByCode(request.getCode())) {
            throw new CodeAlreadyExistsException();
        }

        CountryEntity savedCountry = saveNewCountry(request);

        return CreateCountryResponse.builder()
                .countryId(savedCountry.getId())
                .build();
    }

    private CountryEntity saveNewCountry(CreateCountryRequest request) {
        CountryEntity newCountry = CountryEntity.builder()
                .code(request.getCode())
                .name(request.getName())
                .build();
        return countryRepository.save(newCountry);
    }
}
