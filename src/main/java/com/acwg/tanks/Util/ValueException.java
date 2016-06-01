package com.acwg.tanks.Util;

/**
 * Created by Eugen on 6/1/2016.
 */
public class ValueException extends Exception {
    private String key;
    public ValueException(String key, String message){
        super(message);
        this.key = key;
    }
}
