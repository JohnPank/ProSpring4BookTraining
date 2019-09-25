package com.johnpank.chapter10.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("toIntConverter")
public class StringToIntConverter implements Converter {
    @Override
    public Object convert(Object source) {
        return Integer.parseInt((String) source);
    }
}
