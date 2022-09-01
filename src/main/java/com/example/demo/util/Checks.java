package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import com.example.demo.exception.AppException;


public class Checks {

    public static void isTrue(boolean param, String message) {
        if (!param) throw newE(message);
    }

    public static void isTrue(boolean param, String message, int status) {
        if (!param) throw newE(message, status);
    }

    public static <U extends RuntimeException> void isTrue(boolean param, U exception) {
        if (!param) throw exception;
    }

    public static void nonNull(Object param, String message) {
        if (param == null) throw newE(message);
    }

    public static void nonNull(Object param, String message, int status) {
        if (param == null) throw newE(message, status);
    }

    public static <U extends RuntimeException> void nonNull(Object param, U exception) {
        if (param == null) throw exception;
    }

    public static void hasText(CharSequence param, String message) {
        if (StringUtils.isBlank(param)) throw newE(message);
    }

    public static void hasText(CharSequence param, String message, int status) {
        if (StringUtils.isBlank(param)) throw newE(message, status);
    }

    public static <U extends RuntimeException> void hasText(CharSequence param, U exception) {
        if (StringUtils.isBlank(param)) throw exception;
    }

    public static void throwE(String message) {
        throw newE(message);
    }

    public static AppException newE(String message) {
        return new AppException(message);
    }

    public static AppException newE(String message, int status) {
        return new AppException(message, status);
    }

    public static AppException newE(String message, int status, Object data) {
        return new AppException(message, status, data);
    }

}
