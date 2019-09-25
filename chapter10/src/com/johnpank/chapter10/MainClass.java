package com.johnpank.chapter10;

import com.johnpank.chapter10.config.AppConfig;
import com.johnpank.chapter10.converters.MobilkaToSmartConverter;
import com.johnpank.chapter10.model.Mobilka;
import com.johnpank.chapter10.model.Smartphone;
import com.johnpank.chapter10.validators.MobilkaValidatorService;
import com.johnpank.chapter10.validators.SmartphoneValidatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("----- START -----");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MobilkaToSmartConverter mobilkaToSmartConverter = (MobilkaToSmartConverter)context.getBean("mobToSmart");
        Validator smartValidator = (Validator) context.getBean("smartphoneValidator");
        MobilkaValidatorService mobilkaValidatorService = (MobilkaValidatorService) context.getBean("mobilkaValidatorService");
        SmartphoneValidatorService smartphoneValidatorService = (SmartphoneValidatorService) context.getBean("smartphoneValidatorService");

        //region Convertion

        System.out.println("before convert");

        Mobilka mobilka = (Mobilka) context.getBean("mobilka");
        Smartphone smartphone = (Smartphone) context.getBean("smartphone");

        System.out.println(mobilka);
        System.out.println(smartphone);

        System.out.println("");
        System.out.println("after convert");

        smartphone = (Smartphone) mobilkaToSmartConverter.convert(mobilka);
        System.out.println(smartphone);

        //endregion

        //region Validation with Validator

        System.out.println("");
        System.out.println("validation smartphone");

        //create errors
//        smartphone.setVendor(null);
        smartphone.setModel(null);
//        smartphone.setRelease(null);
//        smartphone.setAndroidVerAPI(null);

        BeanPropertyBindingResult result = new BeanPropertyBindingResult(smartphone, "smart");
        ValidationUtils.invokeValidator(smartValidator, smartphone, result);
        List<ObjectError> errorList = result.getAllErrors();
        if(errorList.isEmpty())
            System.out.println("no errors");
        for (ObjectError error : errorList)
            System.out.println(error.getCode());

        //endregion

        //region BeanValidation JSR-394

        System.out.println("");
        System.out.println("Validation mobilca");

        //create error
        //mobilka.setModel(null);
        mobilka.setVendor("Moto");

        //validate
        Set<ConstraintViolation<Mobilka>> errors = mobilkaValidatorService.validateMobilka(mobilka);

        //show errors
        if(errors.isEmpty()){
            System.out.println("No errors");
        }else {
            for (ConstraintViolation<Mobilka> violation : errors){
                System.out.println(violation.getInvalidValue() + " " + violation.getMessage());
            }
        }

        //endregion

        //region AssertTrue

        System.out.println("");
        System.out.println("Validation smart with AssertTrue");

        //create error
        smartphone.setAndroidVerAPI(0);

        //validate
        Set<ConstraintViolation<Smartphone>> errorsSmart = smartphoneValidatorService.validateSmart(smartphone);

        //show errors
        if(errorsSmart.isEmpty()){
            System.out.println("No errors");
        }else {
            for (ConstraintViolation<Smartphone> violation : errorsSmart) {
                System.out.println(violation.getMessage());
            }
        }

        //endregion

        context.close();
        System.out.println("----- STOP -----");
    }
}
