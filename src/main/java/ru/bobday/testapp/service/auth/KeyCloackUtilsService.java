package ru.bobday.testapp.service.auth;

import ru.bobday.testapp.dto.user.UserDTO;

public interface KeyCloackUtilsService {

    UserDTO registerUser(UserDTO userDTO);


}
