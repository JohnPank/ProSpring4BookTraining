package com.johnpank.chapter10.validators;


import com.johnpank.chapter10.model.Smartphone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service("smartphoneValidatorService")
public class SmartphoneValidatorService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Smartphone>> validateSmart(Smartphone smaprtphone){
        return validator.validate(smaprtphone);
    }

}

