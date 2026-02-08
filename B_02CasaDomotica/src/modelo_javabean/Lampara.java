package modelo_javabean;

/**
 * Representa una lámpara dentro de la casa domótica.
 * Extiende {@link Dispositivo} y añade el tipo de bombilla que utiliza.
 *
 * @author pencho
 */
public class Lampara extends Dispositivo {

  /** Tipo de bombilla que lleva la lámpara (p.&nbsp;ej. LED, halógena). */
  private String tipoDeBombilla;

  /**
   * Crea una nueva lámpara con el nombre y tipo de bombilla indicados.
   *
   * @param nombre          nombre identificativo de la lámpara
   * @param tipoDeBombilla  tipo de bombilla (p.&nbsp;ej. "LED", "Halógena")
   */
  public Lampara(String nombre, String tipoDeBombilla) {

    super(nombre);
    this.tipoDeBombilla = tipoDeBombilla;

  }

  /**
   * Enciende la lámpara mostrando por consola su nombre y tipo de bombilla.
   */
  @Override
  public void encender() {
    System.out.println("Se ha encendido la lampara " + nombre + " que lleva bombillas tipo " + tipoDeBombilla + ".");
  }

}
