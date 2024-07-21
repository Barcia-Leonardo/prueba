package ar.edu.utn.frc.tup.lciii;

import model.LoadSaveGame;
import model.Match;
import model.MatchMenu;
import model.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainMenuTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {

        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));


    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testShowMenu() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MainMenu menu = new MainMenu();

        menu.showMenu();

        String output = outputStream.toString();

        assertTrue(output.contains("Bienvenido al TPI Estanciero"));
        assertTrue(output.contains("1. Comenzar nuevo juego del estanciero"));
        assertTrue(output.contains("2. Cargar partida"));
        assertTrue(output.contains("3. Sobre los creadores y agradecimientos"));
        assertTrue(output.contains("4. Eliminar partida"));
        assertTrue(output.contains("0. Salir"));
        assertTrue(output.contains("Gracias por jugar!"));
    }
    @Test
    public void testShowCredits() {
        // Simular la entrada del usuario para seleccionar la opción 3 (Mostrar créditos) y luego salir
        String input = "3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Crear una instancia del menú (suponiendo que tu clase se llama MainMenu)
        MainMenu menu = new MainMenu();

        // Ejecutar el método showMenu
        menu.showMenu();

        // Verificar la salida
        String output = outputStream.toString();
        // Comprobar que el texto esperado está en la salida
        assertTrue(output.contains("============================================="));
        assertTrue(output.contains("=== Sobre los creadores y agradecimientos ==="));
        assertTrue(output.contains("Desarrollado por: [El Grupo Numero 1: Estanciero]"));
        assertTrue(output.contains("Compuesto por los siguientes integrantes: "));
        assertTrue(output.contains("Barcia Leonardo, Bravo Diego, Comito Lucrecia, Mine Andres, Perez Juan, Perrone Ian, Vega Victoria"));
        assertTrue(output.contains("Agradecimientos especiales a: [Los Profesores que nos dieron este desafio: Hernan, Mariano y Ezequiel]"));
        assertTrue(output.contains("============================================="));
    }

}