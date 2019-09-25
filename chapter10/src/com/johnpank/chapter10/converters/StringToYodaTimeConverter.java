package com.johnpank.chapter10.converters;


import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class StringToYodaTimeConverter implements Converter {
    private static final String DEF_DATE_PATTERN = "yyyy-MM-dd";

    private DateTimeFormatter dateTimeFormat;
    private String datePattern = DEF_DATE_PATTERN;

    public StringToYodaTimeConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    public StringToYodaTimeConverter() {

    }

    @PostConstruct
    public void init(){
        dateTimeFormat = DateTimeFormat.forPattern(datePattern);
    }

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Object convert(Object dateString) {
        return dateTimeFormat.parseDateTime((String) dateString);
    }
}
