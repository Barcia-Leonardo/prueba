package model.support;

import services.typeUpgradesInterface;

/**
 * Esta clase representa un tipo de mejora en el juego.
 *
 * Un tipo de mejora tiene un nombre asociado y puede proporcionar funcionalidades para visualizar el estado de la propiedad y mostrar el tipo de mejora.
 * Implementa la interfaz typeUpgradesInterface para proporcionar estas funcionalidades.
 *
 * Esta implementación actual proporciona métodos de acceso para obtener el nombre del tipo de mejora y para realizar operaciones de visualización relacionadas con la mejora.
 *
 * @version 2.0
 */
public enum TypeUpgrade implements typeUpgradesInterface {
    CHACRA("Chacra"),
    ESTANCIA("Estancia");

    /** El nombre del tipo de mejora. */
    private final String typeUpgrade;

    /**
     * Constructor de la clase TypeUpgrade.
     *
     * @param typeUpgrade El nombre del tipo de mejora.
     */
    TypeUpgrade(String typeUpgrade) {
        this.typeUpgrade = typeUpgrade;
    }

    /**
     * Obtiene el nombre del tipo de mejora.
     *
     * @return El nombre del tipo de mejora.
     */
    @Override
    public String getTypeUpgrade() {
        return typeUpgrade;
    }

    /**
     * Visualiza el estado de la propiedad asociada con el tipo de mejora.
     *
     * @return El estado de la propiedad asociada con el tipo de mejora.
     */
    @Override
    public Object viewStateProperty() {
        // Implementación para visualizar el estado de la propiedad asociada con el tipo de mejora
        return "Estado de la propiedad para " + typeUpgrade;
    }

    /**
     * Muestra el tipo de mejora.
     *
     * @return El tipo de mejora.
     */
    @Override
    public Object showUpgradeType() {
        // Implementación para mostrar el tipo de mejora
        return "Tipo de mejora: " + typeUpgrade;
    }
}