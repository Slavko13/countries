package ru.bobday.testapp.repository.country;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.bobday.testapp.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepo extends CrudRepository<Country, Integer> {

    @Query("SELECT u FROM Country u WHERE lower(:name) = lower(u.name) ")
    Optional<Country> findByName(String name);

    @Query(value = "SELECT * FROM country\n" +
            "WHERE top_level_domain LIKE %?1%", nativeQuery = true)
    List<Country> findByTopLevelDomainContains(@Param("name") String name);

}
