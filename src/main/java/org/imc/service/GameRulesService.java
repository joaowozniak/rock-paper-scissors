package org.imc.service;

import org.imc.model.Choice;
import org.imc.model.Result;

import static org.imc.model.Choice.SCISSORS;
import static org.imc.model.Result.*;

public class GameRulesService {
    public Result compareChoices(Choice playerOneChoice, Choice playerTwoChoice) {
        if (playerOneChoice == playerTwoChoice) {
            return DRAW;
        }

        return switch (playerOneChoice) {
            case ROCK -> (playerTwoChoice == SCISSORS) ? WIN : LOSE;
            case PAPER -> (playerTwoChoice == Choice.ROCK) ? WIN : LOSE;
            case SCISSORS -> (playerTwoChoice == Choice.PAPER) ? WIN : LOSE;
        };
    }
}

