package ru.bobday.testapp.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bobday.testapp.domain.Country;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;
    private String firstName;
    private String secondName;
    private String email;
    private String username;
    private Integer countryId;

}
