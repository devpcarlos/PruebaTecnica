package com.prueba.tecno.Helpers;

import com.prueba.tecno.exceptions.ExceptionHelper;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorHelper {

    public static void assertNotNull(
            final Object value,
            final String response
    ) {
        assertNotNull(value, HttpStatus.BAD_REQUEST, response);
    }

    public static void assertNotNull(
            final Object value,
            final HttpStatus status,
            final String response
    ) {

        if (value == null) {
            throw ExceptionHelper.createByHttpStatus(status, response);
        }
    }

    public static void assertNotEmpty(
            final Object value,
            final String response
    ) {
        assertNotEmpty(value, HttpStatus.BAD_REQUEST, response);
    }

    public static void assertNotEmpty(
            final Object value,
            final HttpStatus status,
            final String response
    ) {
        if (value == null) {
            return;
        }

        if (value instanceof List) {
            final List<?> list = (List) value;

            if (list.isEmpty()) {
                throw ExceptionHelper.createByHttpStatus(status, response);
            }

            return;
        }

        if (value.toString().trim().isEmpty()) {
            throw ExceptionHelper.createByHttpStatus(status, response);
        }
    }

    public static void assertNotNullNotEmpty(
            final Object value,
            final String response
    ) {
        assertNotNullNotEmpty(value, HttpStatus.BAD_REQUEST, response);
    }

    public static void assertNotNullNotEmpty(
            final Object value,
            final HttpStatus status,
            final String response
    ) {
        assertNotNull(value, status, response);
        assertNotEmpty(value, status, response);
    }

    public static void assertPattern(
            final String value,
            final String pattern,
            final String response
    ) {
        assertPattern(value, pattern, HttpStatus.BAD_REQUEST, response);
    }

    public static void assertPattern(
            final String value,
            final String pattern,
            final HttpStatus status,
            final String response
    ) {

        if (pattern == null) {
            return;
        }

        final Pattern pat = Pattern.compile(pattern);
        final Matcher mat = pat.matcher(value);

        if (mat.matches()) {
            return;
        }

        throw ExceptionHelper.createByHttpStatus(status, response);
    }
}
