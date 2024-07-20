package model.player;

import model.board.*;
import model.player.Player;
import model.player.TypePlayer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Aggresive representa un jugador agresivo en el juego.
 *
 * Un jugador agresivo tiene una lista de provincias preferidas y propiedades compradas.
 * Este jugador toma decisiones de compra basadas en sus preferencias y el tipo de propiedad.
 * También decide si mejorar propiedades dependiendo de su disponibilidad de efectivo.
 *
 * @autor GRUPO NUMERO 1: ESTANCIERO
 * @version 2.0
 */

public class Aggresive extends Player implements Serializable {

    /** Las provincias preferidas del jugador. */
    private Provinces provinces;

    /** La propiedad actual del jugador. */
    private Property property;

    /** Contador para llevar la cuenta de algo (no especificado). */
    private int contador = 0;

    /** Lista de provincias preferidas. */
    private List<Provinces> preferredProvinces;

    /** Lista de propiedades compradas. */
    private List<Property> purchasedProperties;

    /**
     * Constructor que inicializa un jugador agresivo con nombre, tipo, turno, ficha y lista de jugadores.
     *
     * @param playerName El nombre del jugador.
     * @param typePlayer El tipo de jugador.
     * @param turn El turno del jugador.
     * @param pawn La ficha del jugador.
     * @param players La lista de jugadores en el juego.
     */
    public Aggresive(String playerName, TypePlayer typePlayer, Integer turn, Pawn pawn, List<Player> players) {
        super(playerName, typePlayer, turn, pawn, players);
        this.preferredProvinces = listProvincePreferred();
        this.purchasedProperties = new ArrayList<>();
    }

    /**
     * Devuelve la lista de las provincias preferidas.
     *
     * @return Una lista de provincias preferidas.
     */
    public List<Provinces> listProvincePreferred(){
        List<Provinces> preferredProvinces = new ArrayList<>();
        for (Provinces provinces : Provinces.values()) {
            if(provinces.getNameProvinces().equals("Tucuman") ||
                    provinces.getNameProvinces().equals("Cordoba") ||
                    provinces.getNameProvinces().equals("Buenos Aires")){
                preferredProvinces.add(provinces);
            }
        }
        return preferredProvinces;
    }

    /**
     * Toma una decisión de compra basada en si la propiedad es una provincia preferida,
     * o si es del tipo ferrocarril o compañía.
     *
     * También verifica si alguna de sus provincias preferidas está activa.
     *
     * @param property La propiedad a evaluar para la compra.
     * @param cash La cantidad de dinero disponible.
     * @return true si decide comprar la propiedad, false en caso contrario.
     */
    public boolean purchaseDecision(Property property, BigDecimal cash) {
        boolean purchased = preferredProvinces.stream()
                .anyMatch(province -> purchasedProperties.stream()
                        .anyMatch(p -> p.getProvince() == province));

        if (preferredProvinces.contains(property.getProvince()) ||
                property.getTypeProperty() == TypeProperty.FERROCARRIL ||
                property.getTypeProperty() == TypeProperty.COMPAÑIA) {
            return true;
        } else if (purchased) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Decide si mejorar una propiedad basada en el costo y el efectivo disponible.
     *
     * Este método siempre mejorará si tiene el dinero para la construcción.
     *
     * @param property La propiedad a mejorar.
     * @param cost El costo de la mejora.
     * @param cash El efectivo disponible.
     * @return true si decide mejorar la propiedad, false en caso contrario.
     */
    public boolean improvementDecision (Property property, int cost, int cash) {
        return false;
    }


    /**
     * Establece la lista de propiedades compradas por el jugador.
     *
     * @param purchasedProperties La lista de propiedades compradas.
     */
    public void setPurchasedProperties(List<Property> purchasedProperties) {
    }
}
