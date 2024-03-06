package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    boolean existsByCode(String code);

    boolean existsById(long countryId);

    CountryEntity findById(long countryId);

    CountryEntity save(CountryEntity country);

    List<CountryEntity> findAll();

    int count();

    Optional<CountryEntity> getById(long countryId);

    void deleteById(long countryID);
}
