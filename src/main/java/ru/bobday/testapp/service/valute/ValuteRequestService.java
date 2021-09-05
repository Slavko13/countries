package ru.bobday.testapp.service.valute;

import org.json.simple.parser.ParseException;
import ru.bobday.testapp.domain.valute.Valute;

public interface ValuteRequestService {

    Valute updateValuteInfo() throws ParseException;

}
