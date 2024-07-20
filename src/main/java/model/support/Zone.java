package model.support;

/**
 * Esta clase representa una zona en el juego.
 *
 * Una zona tiene un nombre asociado.
 * Se utiliza para identificar diferentes zonas en el juego.
 *
 * @version 2.0
 */
public enum Zone {

  SUR("Sur"),
  CENTRO("Centro"),
  NORTE("Norte"),
  PETROLERA("Compañia Petrolera"),
  BODEGA("Bodega"),
  INGENIO("Ingenio"),
  FERROCARRIL("Ferrocarril");


  /** El nombre de la zona. */
  private final String name;

  /**
   * Constructor de la clase Zone.
   *
   * @param name El nombre de la zona.
   */
  Zone(String name) {
    this.name = name;
  }

  /**
   * Obtiene el nombre de la zona.
   *
   * @return El nombre de la zona.
   */
  public String getName() {
    return name;
  }
}
