package com.pcorrea.workshopmongo.resources.util;

import org.springframework.data.mongodb.core.aggregation.DateOperators;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text){
        try{
            return URLDecoder.decode(text,"UTF-8"); // Statico para não precisar instanciar o objeto, se colocar somente o retorno ele vai dar erro precisando de uma verificação => vai decodificar o URL text e retornar o codigo do espaço por exemplo
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertDate(String textDate, Date defaultValue){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try{
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
