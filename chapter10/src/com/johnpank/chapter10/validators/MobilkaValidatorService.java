package com.johnpank.chapter10.validators;

import com.johnpank.chapter10.model.Mobilka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service("mobilkaValidatorService")
public class MobilkaValidatorService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Mobilka>> validateMobilka(Mobilka mobilka){
        return validator.validate(mobilka);
    }

}
