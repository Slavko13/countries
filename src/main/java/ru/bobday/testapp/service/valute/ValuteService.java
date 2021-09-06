package ru.bobday.testapp.service.valute;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.bobday.testapp.domain.valute.Valute;
import ru.bobday.testapp.dto.valute.ValuteRequestDTO;
import ru.bobday.testapp.repository.valute.ValuteRepo;
import ru.bobday.testapp.service.json.JsonRequestService;

import java.util.Map;

@Service
public class ValuteService implements ValuteRequestService{

    @Value("${valute.request.url}")
    private String url;

    @Value("${access.valute.key}")
    private String accessKey;

    private final ValuteRepo valuteRepo;
    private final JsonRequestService jsonRequestService;

    public ValuteService(ValuteRepo valuteRepo, JsonRequestService jsonRequestService) {
        this.valuteRepo = valuteRepo;
        this.jsonRequestService = jsonRequestService;
    }

    @Override
    public Valute updateValuteInfo() throws ParseException {
        String jsonResponse =  jsonRequestService.getJsonFromUrlApi(url+accessKey);
        JsonObject fullJson = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject jsonRates =  fullJson.get("rates").getAsJsonObject();
        Map<String, Double> rates = new Gson().fromJson(jsonRates, new TypeToken<Map<String, Double>>(){}.getType());
        ValuteRequestDTO valuteRequestDTO = new Gson().fromJson(fullJson, new TypeToken<ValuteRequestDTO>() {}.getType());
        Valute valute = Valute.builder()
                .baseValuteCode(valuteRequestDTO.getBase())
                .requestDate(valuteRequestDTO.getDate())
                .rates(rates)
                .build();
        return valuteRepo.save(valute);
    }
}
