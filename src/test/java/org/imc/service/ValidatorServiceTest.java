package org.imc.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.imc.model.Choice;
import org.imc.service.ValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceTest {

    private ValidatorService validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
    }

    @Test
    void validateChoice_WithValidInput() {
        for (Choice choice : Choice.values()) {
            Optional<Choice> result = validatorService.validateChoice(choice.name());
            assertTrue(result.isPresent());
            assertEquals(choice, result.get());
        }
    }

    @Test
    void validateChoice_WithInvalidInput() {
        String invalidInput = "InvalidChoice";
        Optional<Choice> result = validatorService.validateChoice(invalidInput);
        assertFalse(result.isPresent());
    }
}
