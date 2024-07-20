package model.board;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un banco con su nombre y la cantidad de dinero que posee.
 *
 * Además, gestiona las propiedades que posee el banco.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public class Bank implements Serializable {
    /** El nombre del banco. */
    private String bank;

    /** La cantidad de dinero que posee el banco. */
    private BigDecimal money;

    /** Las propiedades que posee el banco. */
    private List<Property> properties;


    /**
     * Constructor por defecto que inicializa el nombre del banco, el dinero y la lista de propiedades.
     */
    public Bank() {
        bank = "Argentina";
        money = BigDecimal.valueOf(999999999);
        properties = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del banco.
     *
     * @return El nombre del banco.
     */
    public String getBank() {
        return bank;
    }

    /**
     * Establece el nombre del banco.
     *
     * @param bank El nuevo nombre del banco.
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * Obtiene la cantidad de dinero que posee el banco.
     *
     * @return La cantidad de dinero del banco.
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * Establece la cantidad de dinero que posee el banco.
     *
     * @param money La nueva cantidad de dinero del banco.
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * Obtiene la lista de propiedades que posee el banco.
     *
     * @return La lista de propiedades del banco.
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Agrega una propiedad al banco.
     *
     * @param property La propiedad que se agregará al banco.
     */
    public void addProperty(Property property) {
        properties.add(property);
    }

    /**
     * Remueve una propiedad del banco.
     *
     * @param property La propiedad que se removerá del banco.
     * @return true si la propiedad se encontraba en el banco y fue removida, false en caso contrario.
     */
    public boolean removeProperty(Property property) {
        return properties.remove(property);
    }

    /**
     * Verifica si el banco posee una propiedad específica.
     *
     * @param property La propiedad que se desea verificar.
     * @return true si el banco posee la propiedad, false si no.
     */
    public boolean hasProperty(Property property) {
        return properties.contains(property);
    }

    /**
     * Obtiene la primera propiedad del banco
     *
     * @return La primera propiedad del banco, o null si no hay propiedades.
     */
    public Property getProperty() {
        if (!properties.isEmpty()) {
            return properties.get(0);
        }
        return null;
    }

}