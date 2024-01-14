package org.imc;

import org.imc.controller.GameController;
import org.imc.model.ComputerPlayer;
import org.imc.model.HumanPlayer;
import org.imc.service.GameRulesService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class GameRunner {
    public static void main(String[] args) {
        var properties = loadProperties();
        if (properties == null) {
            System.out.println("Unable to continue, application properties could not be loaded.");
            return;
        }

        var rounds = parseInt(properties.getProperty("game.rounds", "3"));
        var gameController = new GameController(new HumanPlayer(), new ComputerPlayer(), new GameRulesService());
        gameController.playRounds(rounds);
    }

    private static Properties loadProperties() {
        var properties = new Properties();
        try (InputStream input = GameRunner.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + "application.properties");
                return null;
            }
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Error reading " + "application.properties" + ": " + ex.getMessage());
            return null;
        }
        return properties;
    }
}