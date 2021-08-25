package ru.bobday.testapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.domain.general.json.converter.ListStringToStringConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import java.util.List;

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
