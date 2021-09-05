package ru.bobday.testapp.service.country;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.ParseException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.dto.CountryRequestDTO;
import ru.bobday.testapp.exception.simpleException.NotFoundException;
import ru.bobday.testapp.repository.country.CountryRepo;
import ru.bobday.testapp.service.json.JsonRequestService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryService implements CountryCrudMainService, CountryFilterService {

    private final CountryRepo countryRepo;
    private final JsonRequestService jsonRequestService;

    @Value("${countries.request.url}")
    private String url;

    public CountryService(CountryRepo countryRepo, JsonRequestService jsonRequestService) {
        this.countryRepo = countryRepo;
        this.jsonRequestService = jsonRequestService;
    }

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepo.findAll();
    }


    @Override
    public List<Country> updateCountries() throws ParseException {
        deleteCountries();
        return downloadAndSaveAllCountries();
    }


    @Override
    public Country getCountryByName(String name) {
        return countryRepo.findByName(name).orElseThrow(()-> new NotFoundException("Country by name not found"));
    }

    @Override
    public List<Country> getCountryByDomainName(String domainName) {
        List<Country> countries = countryRepo.findByTopLevelDomainContains(domainName);
        return countries;
    }

    private List<Country> downloadAndSaveAllCountries() throws ParseException {
        String jsonResponse =  jsonRequestService.getJsonFromUrlApi(url);
        JsonArray jsonArray =  JsonParser.parseString(jsonResponse).getAsJsonArray();
        List<Country> countries = new ArrayList<>();
        List<CountryRequestDTO> countryRequestDTOS = new Gson().fromJson(jsonArray, new TypeToken<List<CountryRequestDTO>>() {}.getType());


        for (CountryRequestDTO countryRequestDTO: countryRequestDTOS) {
            Country country = new Country();
            BeanUtils.copyProperties(countryRequestDTO, country);
            country.setTopLevelDomain(Arrays.asList(countryRequestDTO.getTopLevelDomain()));
            country.setCurrencies(Arrays.asList(countryRequestDTO.getCurrencies()));
            country.setLanguages(Arrays.asList(countryRequestDTO.getLanguages()));
            country.setLatLng(Arrays.asList(countryRequestDTO.getLatlng()));
            country.setRegionalBlocs(Arrays.asList(countryRequestDTO.getRegionalBlocs()));
            countries.add(country);
        }
        return (List<Country>) countryRepo.saveAll(countries);
    }

    private void deleteCountries() {
        countryRepo.deleteAll();
    }


}
