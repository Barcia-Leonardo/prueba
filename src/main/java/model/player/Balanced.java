package model.player;

import model.board.Pawn;
import model.board.Property;
import model.board.Provinces;
import model.board.TypeProperty;
import model.player.Player;
import model.player.TypePlayer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Balanced extends Player implements Serializable {
    private Property property;
    private int contador = 0;
    private int totalProperties;
    private int propertiesSold;


    public Balanced(String playerName, TypePlayer typePlayer, Integer turn, Pawn pawn, List<Player> players) {
        super(playerName, typePlayer, turn, pawn,players);
        this.totalProperties = 0;
        this.propertiesSold = 0;
    }

    /*este metodo devuelve la lista de las provincias preferidas
     *
     *
     * */
    /**
     * Método que devuelve la lista de las provincias preferidas.
     *
     * @return Lista de provincias preferidas.
     */

    public List<Provinces> listProvincepreferred() {
        List<Provinces> preferredProvinces = new ArrayList<>();
        // Iteramos sobre todos los valores del enum Provinces
        for (Provinces province : Provinces.values()) {
            if (province.getNameProvinces().equals("Mendoza") ||
                    province.getNameProvinces().equals("Santa Fe") ||
                    province.getNameProvinces().equals("Tucumán")) {
                preferredProvinces.add(province);
            }
        }
        return preferredProvinces;
    }
    /*decicion de la compra donde pregunta si es una provincia preferida
     * o que sea del typo ferrocarril lo comprara si no
     * comprara 1 de cada 3
     * */

    /**
     * Método que toma la decisión de compra de una propiedad.
     *
     * @param property Propiedad a considerar.
     * @param cash     Dinero disponible para la compra.
     * @return true si decide comprar la propiedad, false en caso contrario.
     */
    public boolean purchaseDecision(Property property, BigDecimal cash) {
        List<Provinces> provincesList = listProvincepreferred();
        if (provincesList.contains(property.getProvince()) ||
                property.getTypeProperty() == TypeProperty.FERROCARRIL) {
            return true;
        } else {
            contador++;
            return contador % 3 == 0;
        }
    }


    /**
     * Método que toma la decisión de mejora de una propiedad.
     *
     * @param property Propiedad a mejorar.
     * @param cost     Costo de la mejora.
     * @param cash     Dinero disponible para la mejora.
     * @return true si decide mejorar la propiedad, false en caso contrario.
     */
    public boolean mejoraDecision(Property property, int cost, int cash) {
        double percentageSold = (double) propertiesSold / totalProperties;
        return cost <= 0.5 * cash || percentageSold > 0.75;
    }


}
