package ru.bobday.testapp.domain.general.json.converter;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Converter
public class ListDoubleToString implements AttributeConverter<List<Double>, String> {

    @Override
    public String convertToDatabaseColumn(List<Double> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        return StringUtils.join(attribute, ",");
    }

    @Override
    public List<Double> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return new ArrayList<Double>();
        }

        List<String> data = Arrays.asList(dbData.split(","));
        List<Double> latlng = new ArrayList<>();

        for (String string: data) {
            latlng.add(Double.valueOf(string));
        }
        return latlng;
    }



}
