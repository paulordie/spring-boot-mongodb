package com.pcorrea.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String text){
        try{
            return URLDecoder.decode(text,"UTF-8"); // Statico para não precisar instanciar o objeto, se colocar somente o retorno ele vai dar erro precisando de uma verificação => vai decodificar o URL text e retornar o codigo do espaço por exemplo
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
