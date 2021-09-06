package ru.bobday.testapp.service.auth;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.bobday.testapp.dto.user.UserDTO;
import ru.bobday.testapp.service.json.JsonRequestService;

@Service
public class KeyCloackUtilsServiceImpl implements KeyCloackUtilsService {

    private final JsonRequestService jsonRequestService;

    @Value("${keycloak.admin.username}")
    private String adminUsername;

    @Value("${keycloak.admin.password}")
    private String adminPassword;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    public KeyCloackUtilsServiceImpl(JsonRequestService jsonRequestService) {
        this.jsonRequestService = jsonRequestService;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return null;
    }


    private String getSuperAdminToken() throws ParseException {
        String url =  authServerUrl + "/realms/master/protocol/openid-connect/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", "admin-cli");
        map.add("username", adminUsername);
        map.add("password", adminPassword);
        map.add("client_secret", "85e72404-327e-4d3b-b922-b62399df6e47");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        JSONObject responseJSON = (JSONObject) new JSONParser().parse(jsonRequestService.postJsonFromUtlApi(url, request));
        return responseJSON.get("access_token").toString();

    }

}
