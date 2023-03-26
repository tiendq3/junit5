package com.example.demojunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static com.example.demojunit.EmailValidator.validateEmail;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
    @Test
    void validateEmailTest() {
        String email1 = "tiendq3@gmail.com";
        String email2 = "tientho@tientho.gmail.com";
        String email3 = "tientho@gmail";
        String email4 = "tien..tho110@gmail.com";
        String email5 = "@gmail.com";
        String email6 = "";
        String email7 = null;

        assertTrue(validateEmail(email1),"email wrong");
        assertTrue(validateEmail(email4),"email cannot have 2 consecutive dots");
        assertTrue(validateEmail(email5),"email must have an @ before");
        assertTrue(validateEmail(email6),"email musntn't empty");
        assertTrue(validateEmail(email7),"email mustn't null");
//
        assertTrue(validateEmail(email2),"email có subdomain sau dấu @");
        assertTrue(validateEmail(email3),"email thiếu .com");
    }
    @Test
    void checkFileExist(@TempDir Path path) throws IOException {
        Path file = path.resolve("myfile.txt");
        List<String> input = Arrays.asList("input1", "input2", "input3");
        Files.write(file, input);
        assertTrue(Files.exists(file), "File should exist");
    }
}
