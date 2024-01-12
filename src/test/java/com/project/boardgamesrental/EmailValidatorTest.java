package com.project.boardgamesrental;

import com.project.boardgamesrental.service.AccountService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmailValidatorTest {

    @Autowired
    AccountService accountService;
    
    @Test
    public void testValidEmail() {
        // Arrange
        String validEmail = "test@example.com";

        // Act
        boolean result = accountService.isValidEmail(validEmail);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        // Arrange
        String invalidEmail = "testexample.com";

        // Act
        boolean result = accountService.isValidEmail(invalidEmail);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidEmailMissingDotAfterAtSymbol() {
        // Arrange
        String invalidEmail = "test@examplecom";

        // Act
        boolean result = accountService.isValidEmail(invalidEmail);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidEmailInvalidCharacters() {
        // Arrange
        String invalidEmail = "test!@example.com";

        // Act
        boolean result = accountService.isValidEmail(invalidEmail);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidEmailInvalidTLD() {
        // Arrange
        String invalidEmail = "test@example.123";

        // Act
        boolean result = accountService.isValidEmail(invalidEmail);

        // Assert
        assertFalse(result);
    }
}
