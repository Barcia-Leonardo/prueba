package model.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una provincia en el juego.
 *
 * Una provincia tiene un identificador y un nombre asociado.
 * Se utiliza para representar diferentes regiones en el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public enum Provinces implements Serializable {

    FORMOSA(1, "Formosa"),
    RIONEGRO(2, "Río Negro"),
    SALTA(3, "Salta"),
    MENDOZA(4, "Mendoza"),
    SANTAFE(5, "Santa Fe"),
    TUCUMAN(6, "Tucumán"),
    CORDOBA(7, "Córdoba"),
    BUENOSAIRES(8, "Buenos Aires"),
    COMPANY(9, "Company"),
    FERROCARRIL(10, "Railway");

    private final int id_provinces;

    private final String nameProvinces;

    Provinces(int id_provinces, String nameProvinces) {
        this.id_provinces = id_provinces;
        this.nameProvinces = nameProvinces;
    }

    public int getIdProvinces() {
        return id_provinces;
    }

    public String getNameProvinces() {
        return nameProvinces;
    }

    public List<Provinces> getNameListProvinces() {
        return new ArrayList<>();
    }
    
}
