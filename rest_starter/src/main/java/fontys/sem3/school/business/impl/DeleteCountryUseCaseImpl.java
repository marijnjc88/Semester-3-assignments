package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.DeleteCountryUseCase;
import fontys.sem3.school.persistence.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCountryUseCaseImpl implements DeleteCountryUseCase {
    private final CountryRepository countryRepository;

    @Override
    public void deleteCountry(long countryId) {
        this.countryRepository.deleteById(countryId);
    }
}
