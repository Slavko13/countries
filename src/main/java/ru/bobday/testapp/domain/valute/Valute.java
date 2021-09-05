package ru.bobday.testapp.domain.valute;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Valute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer countryId;

    @Column(name = "valute_code")
    private String ValuteCode;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "base_valute_code")
    private String baseValuteCode;

    @ElementCollection
    private Map<String, Double> rates;

}
