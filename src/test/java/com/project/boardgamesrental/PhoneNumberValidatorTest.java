package com.project.boardgamesrental;

import com.project.boardgamesrental.service.AccountService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PhoneNumberValidatorTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testValidNineDigitPhoneNumber() {
        // Arrange
        String validPhoneNumber = "123456789";

        // Act
        boolean result = accountService.isNineDigitPhoneNumber(validPhoneNumber);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testInvalidPhoneNumberShorterThanNineDigits() {
        // Arrange
        String invalidPhoneNumber = "12345678";

        // Act
        boolean result = accountService.isNineDigitPhoneNumber(invalidPhoneNumber);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPhoneNumberLongerThanNineDigits() {
        // Arrange
        String invalidPhoneNumber = "1234567890";

        // Act
        boolean result = accountService.isNineDigitPhoneNumber(invalidPhoneNumber);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPhoneNumberWithNonNumericCharacters() {
        // Arrange
        String invalidPhoneNumber = "12a345678";

        // Act
        boolean result = accountService.isNineDigitPhoneNumber(invalidPhoneNumber);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPhoneNumberWithSpaces() {
        // Arrange
        String invalidPhoneNumber = "123 456 789";

        // Act
        boolean result = accountService.isNineDigitPhoneNumber(invalidPhoneNumber);

        // Assert
        assertFalse(result);
    }
}
