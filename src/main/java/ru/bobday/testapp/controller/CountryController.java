package ru.bobday.testapp.controller;


import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.service.country.CountryService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @CrossOrigin
    @GetMapping("/update/countries/info")
    public ResponseEntity<List<Country>> requestCountries() throws ParseException {
        return new ResponseEntity<>(countryService.updateCountries(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getAll/fromDB/countries")
    public ResponseEntity<List<Country>> getAll() throws ParseException {
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get/country/byName")
    public ResponseEntity<Country> getCountryByName(@RequestParam String name) throws ParseException {
        return new ResponseEntity<>(countryService.getCountryByName(name), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get/country/byDomainName")
    public ResponseEntity<List<Country>> getCountryByDomainName(@RequestParam String topLevelDomain) throws ParseException {
        return new ResponseEntity<>(countryService.getCountryByDomainName(topLevelDomain), HttpStatus.OK);
    }

}
