package ru.bobday.testapp.controller;


import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.jetty.core.AbstractKeycloakJettyAuthenticator;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @GetMapping("/current")
    public String getCurrentUser(KeycloakAuthenticationToken principal) {
        return  principal.getAccount().getKeycloakSecurityContext().getToken().getId();

        //        return new User(
//                principal.getKeycloakSecurityContext().getToken().getEmail()
//        );
    }



}
