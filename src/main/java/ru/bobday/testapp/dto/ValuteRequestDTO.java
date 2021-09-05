package ru.bobday.testapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuteRequestDTO {


    private Boolean success;
    private String base;
    private Date date;


}
