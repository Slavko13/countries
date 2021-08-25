package ru.bobday.testapp.service.json;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface JsonRequestService {

    String getJsonFromUrlApi(String url) throws ParseException;

}
