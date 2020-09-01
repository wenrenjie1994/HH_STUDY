package com.cuit.util;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author liwenyi
 * @version 1.0.0
 */
public class ValidateUtils {
    public static String getValidateErrors(List<ObjectError> errors) {
        StringBuilder errorMessage = new StringBuilder();
        for (ObjectError error : errors) {
            errorMessage.append(error.getDefaultMessage());
            errorMessage.append("\n");
        }
        return errorMessage.toString();
    }
}
