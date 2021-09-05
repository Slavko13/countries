package ru.bobday.testapp.controller;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bobday.testapp.domain.valute.Valute;
import ru.bobday.testapp.service.valute.ValuteService;

@RestController
@RequestMapping("/api")
public class ValuteController {

    private final ValuteService valuteService;

    public ValuteController(ValuteService valuteService) {
        this.valuteService = valuteService;
    }


    @CrossOrigin
    @GetMapping("/update/valute/info")
    public ResponseEntity<Valute> requestCountries() throws ParseException {
        return new ResponseEntity<>(valuteService.updateValuteInfo(), HttpStatus.OK);
    }



}
