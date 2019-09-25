package com.johnpank.chapter10.validators;

import com.johnpank.chapter10.model.Smartphone;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("smartphoneValidator")
public class SmaprtphoneValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
       return Smartphone.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "vendor", "vendor is empty");
        ValidationUtils.rejectIfEmpty(errors, "model", "model is empty");
        ValidationUtils.rejectIfEmpty(errors, "release", "release is empty");
        ValidationUtils.rejectIfEmpty(errors, "androidVerAPI", "androidVer is empty");
    }
}
