package ar.edu.utn.frc.tup.lciii;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.LoadSaveGame;
import model.Match; // Asegúrate de tener una clase Match

import java.io.File;

public class SaveGameTest {

    private Match match;
    private String fileName;

    @Before
    public void setUp() {
        match = new Match(); // Asumiendo que tienes una clase Match
        fileName = "testGame.dat";
    }

    @Test
    public void testSaveGame() {
        LoadSaveGame.saveGame(match, fileName);
        File file = new File(fileName);
        assertTrue(file.exists());
    }

    @Test
    public void testLoadGame() {
        LoadSaveGame.saveGame(match, fileName);
        Match loadedMatch = LoadSaveGame.loadGame(fileName);
        assertNotNull(loadedMatch);
    }

    @Test
    public void testDeleteGame() {
        LoadSaveGame.saveGame(match, fileName);
        assertTrue(LoadSaveGame.deleteGame(fileName));
        File file = new File(fileName);
        assertFalse(file.exists());
    }
}
