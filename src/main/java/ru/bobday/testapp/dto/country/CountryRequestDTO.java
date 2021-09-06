package ru.bobday.testapp.dto.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bobday.testapp.domain.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequestDTO {

    private String capital;
    private String name;
    private Long population;
    private Double[] latlng;
    private String[] topLevelDomain;
    private Country.Currency[] currencies;
    private Country.Languages[] languages;
    private Country.Translations translations;
    private Country.RegionalBlocs[] regionalBlocs;
    private String flag;

}
