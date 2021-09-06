package ru.bobday.testapp.service.user;

import org.springframework.stereotype.Service;
import ru.bobday.testapp.domain.user.CountryUser;
import ru.bobday.testapp.dto.user.UserDTO;
import ru.bobday.testapp.service.auth.KeyCloackUtilsService;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserCrudService{

    private final KeyCloackUtilsService keyCloackUtilsService;

    public UserService(KeyCloackUtilsService keyCloackUtilsService) {
        this.keyCloackUtilsService = keyCloackUtilsService;
    }


    @Override
    public CountryUser registerUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public CountryUser updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(UUID userId) {

    }

    @Override
    public List<CountryUser> getAllUsers() {
        return null;
    }

    @Override
    public CountryUser getUserByUserId(UUID userId) {
        return null;
    }
}
