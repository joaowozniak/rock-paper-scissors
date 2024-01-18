package org.imc.service;

import org.imc.model.Choice;
import org.imc.model.Result;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRulesServiceTest {

    private final GameRulesService gameRulesService = new GameRulesService();

    @ParameterizedTest
    @CsvSource({
            "ROCK, SCISSORS, WIN",
            "ROCK, PAPER, LOSE",
            "PAPER, ROCK, WIN",
            "PAPER, SCISSORS, LOSE",
            "SCISSORS, PAPER, WIN",
            "SCISSORS, ROCK, LOSE",
            "ROCK, ROCK, DRAW",
            "PAPER, PAPER, DRAW",
            "SCISSORS, SCISSORS, DRAW"
    })
    void compareChoices_ShouldReturnExpectedResult(Choice playerOneChoice, Choice playerTwoChoice, Result expectedResult) {
        // given
        var result = gameRulesService.compareChoices(playerOneChoice, playerTwoChoice);

        // expect
        assertEquals(expectedResult, result);
    }
}

