package org.imc.model;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final Random random;

    public ComputerPlayer() {
        this.random = new Random();
    }

    @Override
    public Choice choose() {
        return Choice.values()[random.nextInt(Choice.values().length)];
    }
}

