package org.imc.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanPlayerTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Set up a custom System.in before each test
    }

    @AfterEach
    void tearDown() {
        // Restore original System.in after each test
        System.setIn(originalIn);
    }

    @Test
    void choose_WithValidInput() {
        // Given
        String input = "ROCK\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        HumanPlayer humanPlayer = new HumanPlayer();

        // When
        Choice result = humanPlayer.choose();

        // Then
        assertEquals(Choice.ROCK, result);
    }

    @Test
    void choose_WithInvalidThenValidInput() {
        // Given
        String input = "invalid\nPAPER\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        HumanPlayer humanPlayer = new HumanPlayer();

        // When
        Choice result = humanPlayer.choose();

        // Then
        assertEquals(Choice.PAPER, result);
    }
}