package ru.bobday.testapp.repository.user;

import org.springframework.data.repository.CrudRepository;
import ru.bobday.testapp.domain.user.CountryUser;

import java.util.UUID;

public interface UserRepo extends CrudRepository<CountryUser, UUID> {
}
