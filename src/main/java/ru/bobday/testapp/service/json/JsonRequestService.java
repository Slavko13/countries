package ru.bobday.testapp.service.json;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

public interface JsonRequestService {

    String getJsonFromUrlApi(String url) throws ParseException;
    String postJsonFromUtlApi(String url, HttpEntity<MultiValueMap<String, String>> request);
}
