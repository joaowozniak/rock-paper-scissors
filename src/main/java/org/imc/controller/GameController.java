package org.imc.controller;

import org.imc.model.Player;
import org.imc.service.GameRulesService;

import java.util.stream.IntStream;

public class GameController {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final GameRulesService gameRulesService;

    public GameController(Player humanPlayer, Player computerPlayer, GameRulesService gameRulesService) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.gameRulesService = gameRulesService;
    }

    public void playRounds(int rounds) {
        IntStream.range(0, rounds).forEach(i -> {
            System.out.println("\nRound " + (i + 1) + ":");
            playRound();
        });
    }

    private void playRound() {
        var humanChoice = humanPlayer.choose();
        var computerChoice = computerPlayer.choose();

        System.out.println("Your choice: " + humanChoice);
        System.out.println("Computer's choice: " + computerChoice);

        var result = gameRulesService.compareChoices(humanChoice, computerChoice);
        System.out.println("Result: You " + result + "!");
    }
}