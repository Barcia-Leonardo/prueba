package model;

import java.io.*;

public class LoadSaveGame {

    public static void saveGame(Match match, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(match);
            System.out.println("Partida guardada correctamente en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Match loadGame(String archivo) {
        Match match = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            match = (Match) in.readObject();
            System.out.println("Partida cargada correctamente desde " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return match;
    }

    public static boolean deleteGame(String archivo) {
        File file = new File(archivo);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Partida eliminada correctamente desde " + archivo);
                return true;
            } else {
                System.out.println("No se pudo eliminar la partida desde " + archivo);
                return false;
            }
        } else {
            System.out.println("No se encontró una partida guardada para eliminar en " + archivo);
            return false;
        }
    }
}
