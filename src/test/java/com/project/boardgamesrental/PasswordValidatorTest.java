package com.project.boardgamesrental;

import com.project.boardgamesrental.service.AccountService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PasswordValidatorTest {

    @Autowired
    AccountService accountService;

    @Test
    public void testValidPassword() {
        // Arrange
        String validPassword = "Password123!";

        // Act
        boolean result = accountService.isPasswordValid(validPassword);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testInvalidShortPassword() {
        // Arrange
        String invalidPassword = "Short1!";

        // Act
        boolean result = accountService.isPasswordValid(invalidPassword);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidNoLowercaseLetter() {
        // Arrange
        String invalidPassword = "UPPERCASE123!";

        // Act
        boolean result = accountService.isPasswordValid(invalidPassword);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidNoUppercaseLetter() {
        // Arrange
        String invalidPassword = "lowercase123!";

        // Act
        boolean result = accountService.isPasswordValid(invalidPassword);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidNoSpecialCharacter() {
        // Arrange
        String invalidPassword = "MixedCase123";

        // Act
        boolean result = accountService.isPasswordValid(invalidPassword);

        // Assert
        assertFalse(result);
    }
}
