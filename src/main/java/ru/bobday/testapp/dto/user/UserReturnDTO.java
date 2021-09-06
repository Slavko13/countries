package ru.bobday.testapp.dto.user;

import javafx.beans.binding.DoubleExpression;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bobday.testapp.domain.user.CountryUser;
import ru.bobday.testapp.domain.valute.Valute;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReturnDTO {

    private CountryUser countryUser;
    private List<Double> valuteRate;
    private String baseValute;

}
