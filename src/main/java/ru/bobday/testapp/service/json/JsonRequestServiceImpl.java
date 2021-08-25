package ru.bobday.testapp.service.json;


import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class JsonRequestServiceImpl implements JsonRequestService {

    @Override
    public String getJsonFromUrlApi(String url) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }


}
