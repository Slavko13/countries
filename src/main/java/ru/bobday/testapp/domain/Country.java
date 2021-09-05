package ru.bobday.testapp.domain;


import lombok.*;
import ru.bobday.testapp.domain.general.json.converter.*;
import ru.bobday.testapp.domain.user.CountryUser;

import javax.persistence.*;
import java.util.List;

@Table(name = "country")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer countryId;

    private String capital;

    private String name;

    private Long population;

    @Column(name = "lat_lng")
    @Convert(converter = ListDoubleToString.class)
    private List<Double> latLng;

    @Column(name = "top_level_domain", length = 5600)
    @Convert(converter = ListStringToStringConverter.class)
    private List<String> topLevelDomain;

    @Convert(converter = ListCurrencyToStringConverter.class)
    @Column(length = 5600)
    private List<Currency> currencies;

    @Convert(converter = ListLanguagesToStringConverter.class)
    @Column(length = 5600)
    private List<Languages> languages;

    @Convert(converter = TranslationsToStringConverter.class)
    @Column(length = 5600)
    private Translations translations;

    private String flag;

    @Convert(converter = ListRegionalBlocsToStringConverter.class)
    @Column(length = 5600, name = "regional_blocs")
    private List<RegionalBlocs> regionalBlocs;



    @OneToMany(mappedBy = "country", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<CountryUser> countryUsers;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Currency {

        private String code;
        private String name;
        private String symbol;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Languages {

        private String iso639_1;
        private String iso639_2;
        private String name;
        private String nativeName;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Translations {

        private String de;
        private String es;
        private String fr;
        private String ja;
        private String it;
        private String br;
        private String pt;
        private String nl;
        private String hr;
        private String fa;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegionalBlocs {

        private String acronym;
        private String name;
        private String[] otherAcronyms;
        private String[] otherNames;

    }

}
