package org.imc.controller;

import org.imc.model.Player;
import org.imc.service.GameRulesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.imc.model.Choice.ROCK;
import static org.imc.model.Choice.SCISSORS;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @Mock
    private Player humanPlayer;
    @Mock
    private Player computerPlayer;
    @Mock
    private GameRulesService gameRulesService;
    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController(humanPlayer, computerPlayer, gameRulesService);
    }

    @Test
    void playRounds_CallsTheRightMethods() {
        // given
        int rounds = 3;
        when(humanPlayer.choose()).thenReturn(ROCK);
        when(computerPlayer.choose()).thenReturn(SCISSORS);

        // when
        gameController.playRounds(rounds);

        // then
        verify(humanPlayer, times(rounds)).choose();
        verify(computerPlayer, times(rounds)).choose();
        verify(gameRulesService, times(rounds)).compareChoices(ROCK, SCISSORS);
    }
}
