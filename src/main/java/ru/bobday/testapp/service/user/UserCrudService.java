package ru.bobday.testapp.service.user;


import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.domain.user.CountryUser;
import ru.bobday.testapp.dto.user.UserDTO;
import ru.bobday.testapp.dto.user.UserReturnDTO;

import java.util.List;
import java.util.UUID;

public interface UserCrudService {

    CountryUser registerUser(UserDTO userDTO);
    CountryUser updateUser(UserDTO userDTO);
    void deleteUser(UUID userId);
    List<CountryUser> getAllUsers();
    UserReturnDTO getUserByUserId(UUID userId);

}
