package com.johnpank.chapter10.converters;

import com.johnpank.chapter10.model.Mobilka;
import com.johnpank.chapter10.model.Smartphone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("mobToSmart")
public class MobilkaToSmartConverter implements Converter {
    @Override
    public Object convert(Object source) {
        Smartphone smartphone = new Smartphone();
        Mobilka mobilka = (Mobilka)source;
        smartphone.setVendor(mobilka.getVendor());
        smartphone.setModel(mobilka.getModel());
        smartphone.setRelease(mobilka.getRelease());
        smartphone.setAndroidVerAPI(23);

        return smartphone;
    }
}
