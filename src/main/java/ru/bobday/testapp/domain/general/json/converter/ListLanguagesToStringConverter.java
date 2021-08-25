package ru.bobday.testapp.domain.general.json.converter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.bobday.testapp.domain.Country;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class ListLanguagesToStringConverter implements AttributeConverter<List<Country.Languages>, String> {

    @Override
    public String convertToDatabaseColumn(List<Country.Languages> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        Gson gson = new Gson();
        return gson.toJson(attribute);
    }

    @Override
    public List<Country.Languages> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(dbData, new TypeToken<List<Country.Languages>>() {}.getType());
    }


}
