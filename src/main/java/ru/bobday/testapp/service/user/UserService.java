package ru.bobday.testapp.service.user;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.bobday.testapp.domain.Country;
import ru.bobday.testapp.domain.user.CountryUser;
import ru.bobday.testapp.domain.valute.Valute;
import ru.bobday.testapp.dto.user.UserDTO;
import ru.bobday.testapp.dto.user.UserReturnDTO;
import ru.bobday.testapp.exception.simpleException.NotFoundException;
import ru.bobday.testapp.repository.user.UserRepo;
import ru.bobday.testapp.repository.valute.ValuteRepo;
import ru.bobday.testapp.service.auth.KeyCloackUtilsService;
import ru.bobday.testapp.utils.DTOCopyUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserCrudService{

    private final KeyCloackUtilsService keyCloackUtilsService;
    private final UserRepo userRepo;
    private final ValuteRepo valuteRepo;


    public UserService(KeyCloackUtilsService keyCloackUtilsService, UserRepo userRepo, ValuteRepo valuteRepo) {
        this.keyCloackUtilsService = keyCloackUtilsService;
        this.userRepo = userRepo;
        this.valuteRepo = valuteRepo;
    }


    @Override
    public CountryUser registerUser(UserDTO userDTO) {
        CountryUser user = new CountryUser();
        BeanUtils.copyProperties(userDTO, user, DTOCopyUtils.getNullPropertyNames(userDTO));
        return userRepo.save(user);
    }

    @Override
    public CountryUser updateUser(UserDTO userDTO) {
        CountryUser user = userRepo.findById(userDTO.getId()).orElseThrow(() -> new NotFoundException("user not found"));
        BeanUtils.copyProperties(userDTO, user, DTOCopyUtils.getNullPropertyNames(userDTO));
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<CountryUser> getAllUsers() {
        return (List<CountryUser>) userRepo.findAll();
    }

    @Override
    @Transactional
    public UserReturnDTO getUserByUserId(UUID userId) {
        CountryUser user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        List<Country.Currency> currencies = user.getCountry().getCurrencies();
        List<Double> rates = new ArrayList<>();
        Valute valute = ((List<Valute>) valuteRepo.findAll()).get(1);
        for (Country.Currency currency: currencies ) {
            valute.getRates().get(currency.getCode());
        }
        return UserReturnDTO.builder()
                .countryUser(user)
                .baseValute(valute.getBaseValuteCode())
                .valuteRate(rates)
                .build();
    }
}
