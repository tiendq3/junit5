package com.example.demojunit;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean validateEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        return Pattern.matches(emailRegex, email);
    }
}
