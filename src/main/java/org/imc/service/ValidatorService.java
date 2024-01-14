package org.imc.service;

import org.imc.model.Choice;

import java.util.Arrays;
import java.util.Optional;

public class ValidatorService {
    public Optional<Choice> validateChoice(String input) {
        return Arrays.stream(Choice.values())
                .filter(choice -> choice.name().equalsIgnoreCase(input))
                .findFirst();
    }
}
