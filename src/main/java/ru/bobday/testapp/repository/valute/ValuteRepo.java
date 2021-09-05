package ru.bobday.testapp.repository.valute;

import org.springframework.data.repository.CrudRepository;
import ru.bobday.testapp.domain.valute.Valute;

public interface ValuteRepo extends CrudRepository<Valute, Integer> {
}
