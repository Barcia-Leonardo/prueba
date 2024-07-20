package ar.edu.utn.frc.tup.lciii;

import model.LoadSaveGame;
import model.MatchMenu;
import model.board.DrawBoard;
import model.player.Player;
import model.Match;

import java.util.List;
import java.util.Scanner;

public class App {

//    private static final String SAVE_FILE_NAME = "partidaEstanciero";
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        System.out.println("Hello, TPI Estanciero.");
//
//        // Opcionalmente puedes mantener la bienvenida o moverla a MainMenu
//        MatchMenu matchMenu = new MatchMenu();
//        matchMenu.welcomeMessage();
//
//        DrawBoard drawBoard = new DrawBoard();
//
//        runGame(matchMenu, drawBoard);
//
//        System.out.println("Gracias por jugar!");
//    }
//
//    private static void runGame(MatchMenu matchMenu, DrawBoard drawBoard) {
//        Player humanPlayer = matchMenu.createPlayer();
//        matchMenu.mostrarPosiciones(matchMenu.getMatch().getPlayers());
//        matchMenu.chooseDifficult(humanPlayer);
//        List<Player> players = matchMenu.getMatch().getPlayers();
//        matchMenu.printPlayersInfo(players);
//        matchMenu.chooseEnding();
//
//        boolean playAgain;
//        matchMenu.startGame();
//
//        do {
//            matchMenu.playGame();
//            matchMenu.printPlayersInfo(players);
//            matchMenu.simulateSlowPrint();
//            drawBoard.mostrarTablero();
//            matchMenu.mostrarPosiciones(matchMenu.getMatch().getPlayers());
//            matchMenu.simulateSlowPrint();
//            playAgain = matchMenu.wantPlayAgain();
//            if (playAgain) {
//                LoadSaveGame.saveGame(matchMenu.getMatch(), SAVE_FILE_NAME);
//            }
//        } while (playAgain);
//    }
}