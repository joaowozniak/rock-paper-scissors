package org.imc.model;

import org.imc.service.ValidatorService;

import java.util.Optional;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private final ValidatorService validatorService;

    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
        this.validatorService = new ValidatorService();
    }

    @Override
    public Choice choose() {
        Optional<Choice> validatedChoice = Optional.empty();

        while (validatedChoice.isEmpty()) {
            System.out.print("Enter choice (ROCK, PAPER, SCISSORS): ");
            String input = scanner.nextLine();
            validatedChoice = validatorService.validateChoice(input);

            if (validatedChoice.isEmpty()) {
                System.out.println("Invalid choice. Please enter ROCK, PAPER, or SCISSORS.");
            }
        }

        return validatedChoice.get();
    }
}