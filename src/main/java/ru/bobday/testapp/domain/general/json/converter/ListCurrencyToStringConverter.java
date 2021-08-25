package ru.bobday.testapp.domain.general.json.converter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.domain.general.base.CountryFieldBase;
import ru.bobday.testapp.dto.CountryRequestDTO;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class ListCurrencyToStringConverter implements AttributeConverter<List<Country.Currency>, String> {

    @Override
    public String convertToDatabaseColumn(List<Country.Currency> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        Gson gson = new Gson();
        return gson.toJson(attribute);
    }

    @Override
    public List<Country.Currency> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(dbData, new TypeToken<List<Country.Currency>>() {}.getType());
    }


}
