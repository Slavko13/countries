package ru.bobday.testapp.service.country;

import org.json.simple.parser.ParseException;
import ru.bobday.testapp.domain.Country;

import java.util.List;

public interface CountryCrudMainService {

        List<Country> getAllCountries();
        List<Country> updateCountries() throws ParseException;


}
