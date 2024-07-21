package ar.edu.utn.frc.tup.lciii;

import model.LetterByLetterPrinter;
import model.LoadSaveGame;
import model.MatchMenu;
import model.board.DrawBoard;
import model.player.Player;
import model.Match;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private transient Scanner scanner = new Scanner(System.in);
    private MatchMenu matchMenu;
    private static final String SAVE_FILE_NAME = "partidaEstanciero";

    public MainMenu() {
        this.matchMenu = new MatchMenu();
    }
    public MainMenu(MatchMenu matchMenu) {
        this.matchMenu = matchMenu != null ? matchMenu : new MatchMenu();
    }

    public void showMenu() {
        boolean salir = false;

        while (!salir) {
            LetterByLetterPrinter.println("Bienvenido al TPI Estanciero");
            LetterByLetterPrinter.println("1. Comenzar nuevo juego del estanciero");
            LetterByLetterPrinter.println("2. Cargar partida");
            LetterByLetterPrinter.println("3. Sobre los creadores y agradecimientos");
            LetterByLetterPrinter.println("4. Eliminar partida");
            LetterByLetterPrinter.println("0. Salir");

            int opcion = readOption();

            switch (opcion) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    loadGame();
                    break;
                case 3:
                    showCredits();
                    break;
                case 4:
                    deleteGame();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Gracias por jugar!");
                    break;
                default:
                    LetterByLetterPrinter.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

    }

    private int readOption() {
        System.out.println("Ingrese la opción deseada: ");
        while (!scanner.hasNextInt()) {
            LetterByLetterPrinter.println("Ingrese una opción válida: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void startNewGame() {
        if (matchMenu.getMatch() != null) {
            System.out.print("¿Deseas continuar con la partida guardada previamente? (y/n): ");
            if (scanner.hasNextLine()) {
                String continuar = scanner.nextLine().trim().toLowerCase();
                if (continuar.equals("y")) {
                    System.out.println("Cargando partida guardada...");
                    playGame();
                    return;
                } else {
                    System.out.println("(RECUERDE QUE SI NO DESEA CONTINUAR LA PARTIDA GUARDADA SE PERDERA)");
                }
            }
        }

        System.out.println("Comenzando nuevo juego del estanciero...");
        matchMenu.welcomeMessage();
        DrawBoard drawBoard = new DrawBoard();


        Player humanPlayer = matchMenu.createPlayer();
        matchMenu.chooseDifficult(humanPlayer);
        List<Player> players = matchMenu.getMatch().getPlayers();
        matchMenu.printPlayersInfo(players);
        matchMenu.chooseEnding();

        boolean playAgain;
        boolean isFinished;
        matchMenu.startGame();
        matchMenu.playGame();

        do {
            drawBoard.mostrarTablero();
            matchMenu.printPlayersInfo(players);
            playAgain = matchMenu.wantPlayAgain();
            isFinished = matchMenu.playGame();
            LoadSaveGame.saveGame(matchMenu.getMatch(), SAVE_FILE_NAME);
        } while (playAgain && !isFinished);


        showMenu();
    }

    private void loadGame() {
        Match loadedMatch = LoadSaveGame.loadGame(SAVE_FILE_NAME);

        if (loadedMatch != null) {
            matchMenu.setMatch(loadedMatch);
            LetterByLetterPrinter.println("Partida cargada exitosamente.");
            playGame();
        } else {
            LetterByLetterPrinter.println("No se encontró una partida guardada.");
            startNewGame();
        }
    }

    private void deleteGame() {
        if (LoadSaveGame.deleteGame(SAVE_FILE_NAME)) {
            LetterByLetterPrinter.println("Partida eliminada correctamente.");
            matchMenu.setMatch(null);
        } else {
            LetterByLetterPrinter.println("No se encontró una partida guardada para eliminar.");
        }
    }

    private void playGame() {
        if (matchMenu.getMatch() != null) {
            DrawBoard drawBoard = new DrawBoard();
            List<Player> players = matchMenu.getMatch().getPlayers();

            do {
                matchMenu.playGame();
                drawBoard.mostrarTablero();
                matchMenu.printPlayersInfo(players);

                LoadSaveGame.saveGame(matchMenu.getMatch(), SAVE_FILE_NAME);
            } while (matchMenu.wantPlayAgain());


            showMenu();
        }
    }

    private void showCredits() {
        LetterByLetterPrinter.println("=============================================");
        LetterByLetterPrinter.println("=== Sobre los creadores y agradecimientos ===");
        LetterByLetterPrinter.println("Desarrollado por: [El Grupo Numero 1: Estanciero]");
        LetterByLetterPrinter.println("Compuesto por los siguientes integrantes: ");
        LetterByLetterPrinter.println("Barcia Leonardo, Bravo Diego, Comito Lucrecia, Mine Andres, Perez Juan, Perrone Ian, Vega Victoria");
        LetterByLetterPrinter.println("Agradecimientos especiales a: [Los Profesores que nos dieron este desafio: Hernan, Mariano y Ezequiel]");
        LetterByLetterPrinter.println("=============================================");
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
    }

}
