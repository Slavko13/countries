package ru.bobday.testapp.service.country;

import ru.bobday.testapp.domain.Country;

import java.util.List;

public interface CountryFilterService {

    Country getCountryByName(String name);
    List<Country> getCountryByDomainName(String domainName);

}
