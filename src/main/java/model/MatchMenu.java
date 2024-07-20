package model;


import model.board.*;
import model.player.Player;
import model.player.TypePlayer;
import model.support.Difficulty;

import java.util.List;
import java.util.Scanner;
import java.util.function.IntSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchMenu {

    private static final String YES_NO_REGEX = "[yYnN]";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private transient Scanner scanner = new Scanner(System.in);
    private Match match = new Match();

    public void welcomeMessage() {
        System.out.println("Bienvenido al juego del Estanciero!");
    }

    public Player createPlayer() {

        System.out.println("Ingrese su nombre para empezar a jugar:");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, TypePlayer.HUMAN, 0, new Pawn(0, 35000, true),match.getPlayers());

        return player;
    }

    public void startGame() {

        match.setTurns();
    }
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void chooseDifficult(Player humanPlayer){
        LetterByLetterPrinter.println("Elija la dificultad en la que quiere jugar. Escriba el numero.\n " +
                "1. Modo fácil incluye 2 jugadores (1 moderado y 1 conservador) \n" +
                "2. Modo medio incluye 3 jugadores (1 agresivo, 1 moderado y 1 conservador) \n" +
                "3. Modo difícil inlcuye 4 jugadores (1 agresivo, 2 moderados y 1 conservador)");
        Integer option = getValideNumber("[1-3]", "1 al 3");
        switch (option){
            case 1:
                match.setDifficulty(Difficulty.FACIL, humanPlayer);
                break;
            case 2:
                match.setDifficulty(Difficulty.MEDIO, humanPlayer);
                break;
            case 3:
                match.setDifficulty(Difficulty.DIFICIL, humanPlayer);
                break;
        }

    }

    public void chooseEnding() {
        Boolean answer = null;
        do {
            System.out.println("¿Quieres establecer un limite de valor total para ganar la partida? (y/n)");
            scanner.nextLine();
            String input = scanner.nextLine().trim();
            answer = getYesNoAnswer(input);
            if(answer != null && answer || "y".equalsIgnoreCase(input)){
                System.out.println("Escribe el limite de patrimonio: ");
                Integer limit = scanner.nextInt();
                match.setLimitMoney(limit);
            }
        } while(answer == null);
    }

    public Boolean wantPlayAgain() {
        Boolean answer = null;
        do {

            System.out.println("¿Quieres seguir jugando? (y/n)");
            String input = scanner.nextLine().trim();
            answer = getYesNoAnswer(input);
        } while (answer == null);
        return answer;
    }

    public Boolean continuePlaying() {
        Boolean answer = null;
        do {
            System.out.println("¿Quieres continuar la partida? (y/n)");
            String input = scanner.nextLine();
            answer = getYesNoAnswer(input);
        } while (answer == null);
        return answer;
    }

    public Boolean getYesNoAnswer(String input) {
        Pattern pattern = Pattern.compile(YES_NO_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return input.equalsIgnoreCase("y");
        } else {
            System.out.println("Respuesta inválida. Por favor ingresa 'y' o 'n'.");
            return null;
        }
    }
    private Integer getValideNumber(String NUMBER_REGEX, String message) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        while (true) {
            System.out.print("Por favor, ingrese un número entre "+ message +": ");
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre "+ message +": ");
            }
        }
    }

    public boolean playGame() {
        for (Player playerTurn : match.getPlayers()) {
            if(playerTurn.getPlayerGame().getPatrimony()> match.getLimitMoney()){
                LetterByLetterPrinter.println("Felicitaciones, el jugador " + playerTurn.getplayerName() + " ha alcanzado el limite de dinero. Ha ganado la partida");
                return true;
            }
            if (playerTurn.isPrison()) {
                match.PrisonTurn(playerTurn);
            } else {

                Dice dice = new Dice();
                Integer valueDices = dice.getTotalDices();
                LetterByLetterPrinter.println("El jugador " + playerTurn.getplayerName() + " ha sacado los siguiente dados: " + dice.getDiceOne() + " y " + dice.getDiceTwo() + " por lo cual se movera " + valueDices + " casillas");

                Integer playerPositionBeforeDices = playerTurn.getPawn().getPosition();

                match.movePlayerOnBoard(valueDices, playerTurn.getPawn());

                Integer playerPosition = playerTurn.getPawn().getPosition();
                if (playerPosition < playerPositionBeforeDices) {
                    playerTurn.getPlayerGame().receiveMoney(5000);
                    playerTurn.getPlayerGame().addPatrimony(5000);
                    System.out.println("Paso por salida cobre 5000");
                }
                LetterByLetterPrinter.println("El jugador " + playerTurn.getplayerName() + " ha caido en la casilla: " + playerPosition);
                match.executeBox(playerPosition, playerTurn);
                if(!playerTurn.getPlayerGame().getProperties().isEmpty()){askForDecision(playerTurn);}
            }
        }
        return false;
    }

    public void printPlayersInfo(List<Player> players) {
        LetterByLetterPrinter.println("Información de los jugadores:\n");
        String[] colors = {ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN};

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            String color = colors[i % colors.length];

            LetterByLetterPrinter.println(color + "Nombre: " + player.getplayerName());
            LetterByLetterPrinter.println("Dinero: " + player.getPlayerGame().getMoney());
            LetterByLetterPrinter.println("Patrimonio: " + player.getPlayerGame().getPatrimony());
            LetterByLetterPrinter.println("-----------------------------");

            mostrarPosiciones(player);

            mostrarPropiedadesJugadores(player);

            LetterByLetterPrinter.println("-----------------------------");
        }

        LetterByLetterPrinter.println(ANSI_RESET);
    }

    public void mostrarPosiciones(Player player) {
        System.out.println("Posiciones de " + player.getplayerName() + ":");
        String color = getColorForPlayer(player);
        Pawn pawn = player.getPawn();
        System.out.println(color + " La Posición en casilla es: " + pawn.getPosition());
    }

    public void mostrarPropiedadesJugadores(Player player) {
        System.out.println("Propiedades de " + player.getplayerName() + ":");
        String color = getColorForPlayer(player);
        List<Property> properties = player.getPlayerGame().getProperties();

        for (Property property : properties) {
            System.out.println(color + "- " + property.viewProperty());
        }
        System.out.println("Total de propiedades: " + properties.size());
        System.out.println(ANSI_RESET);
    }

    public String getColorForPlayer(Player player) {
        String[] colors = {ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN};
        int index = match.getPlayers().indexOf(player) % colors.length;
        return colors[index];
    }
    public void movePlayers(List<Player> players, int steps) {
        for (Player player : players) {
            Pawn pawn = player.getPawn();
            pawn.movePawn(steps);
        }
    }
    public void askForDecision(Player playerTurn) {
        int option = 0;
        if(playerTurn.getTypePlayer().equals(TypePlayer.HUMAN)) {
            LetterByLetterPrinter.println(playerTurn.getplayerName() + " deseas realizar alguna de estas actividades?" +
                    "\n 0. Salir" +
                    "\n 1. Hipotecar propiedad.");
            List<Property> propertiesForUpgrade = match.getPropertiesForUpgrade(playerTurn);
            if (propertiesForUpgrade.size() > 0) {
                LetterByLetterPrinter.println(" 2. Mejorar propiedad. Comprar chacra o estancia.");
                option = getValideNumber("[0-2]", "0 al 2");
            }
            else{option = getValideNumber("[0-1]", "0 al 1"); }

            switch (option) {
                case 0:
                    LetterByLetterPrinter.println("Ha decidido salir del menu.");
                    break;
                case 1:
                    mostrarPropiedadesJugadores(playerTurn);
                    playerTurn.getPlayerGame().sellProperty();
                case 2:
                    playerTurn.getPlayerGame().upgradeProperty(propertiesForUpgrade);
            }
        }
    }

}
