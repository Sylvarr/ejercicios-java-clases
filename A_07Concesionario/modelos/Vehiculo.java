package A_07Concesionario.modelos;

/**
 * Clase base que representa un vehículo genérico. Contiene los atributos
 * comunes a todos los vehículos.
 */
public class Vehiculo {

  private String marca;
  private String modelo;
  private double precio;

  /**
   * Constructor que inicializa los atributos del vehículo.
   * 
   * @param marca  Marca del vehículo
   * @param modelo Modelo del vehículo
   * @param precio Precio del vehículo
   */
  public Vehiculo(String marca, String modelo, double precio) {
    this.marca = marca;
    this.modelo = modelo;
    this.precio = precio;
  }

  /**
   * Muestra los detalles del vehículo por consola.
   */
  public void mostrarDetalles() {
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Precio: " + precio);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((marca == null) ? 0 : marca.hashCode());
    result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
    long temp;
    temp = Double.doubleToLongBits(precio);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vehiculo other = (Vehiculo) obj;
    if (marca == null) {
      if (other.marca != null)
        return false;
    } else if (!marca.equals(other.marca))
      return false;
    if (modelo == null) {
      if (other.modelo != null)
        return false;
    } else if (!modelo.equals(other.modelo))
      return false;
    if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
      return false;
    return true;
  }

}
