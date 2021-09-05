package ru.bobday.testapp.domain.general.json.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.bobday.testapp.domain.Country;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TranslationsToStringConverter implements AttributeConverter<Country.Translations, String> {

    @Override
    public String convertToDatabaseColumn(Country.Translations attribute) {
        if (attribute == null) {
            return "";
        }
        Gson gson = new Gson();
        return gson.toJson(attribute);
    }

    @Override
    public Country.Translations convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(dbData, new TypeToken<Country.Translations>() {}.getType());
    }




}
