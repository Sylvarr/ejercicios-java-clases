package A_07Concesionario.modelos;

/**
 * Clase que representa un coche. Hereda de Vehiculo y añade el atributo
 * numeroPuertas.
 */
public class Coche extends Vehiculo {

  private int numeroPuertas;

  /**
   * Constructor del coche que valida el número de puertas.
   * 
   * @param marca         Marca del coche
   * @param modelo        Modelo del coche
   * @param precio        Precio del coche
   * @param numeroPuertas Número de puertas (2 o 4)
   * @throws IllegalArgumentException Si el número de puertas no es 2 o 4
   */
  public Coche(String marca, String modelo, double precio, int numeroPuertas) {

    super(marca, modelo, precio);
    setNumeroPuertas(numeroPuertas);

  }

  /**
   * Asigna el número de puertas validando que sea 2 o 4.
   * 
   * @param numeroPuertas Número de puertas a asignar
   */
  public void setNumeroPuertas(int numeroPuertas) {

    if (numeroPuertas == 4 || numeroPuertas == 2) {
      this.numeroPuertas = numeroPuertas;
    } else {
      throw new IllegalArgumentException("Error fatal: El coche debe tener 2 o 4 puertas.");
    }

  }

  /**
   * Obtiene el número de puertas del coche.
   * 
   * @return Número de puertas
   */
  public int getNumeroPuertas() {
    return numeroPuertas;
  }

  @Override
  public void mostrarDetalles() {
    super.mostrarDetalles();
    System.out.println("Numero de Puertas: " + numeroPuertas);
  }

  @Override
  public String toString() {
    return "Coche [numeroPuertas=" + numeroPuertas + "]";
  }

}
