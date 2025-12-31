package A_04Pizzeria.modelos;

public class Pizza {

  private String nombre;
  private String tamaño;
  private double precio;

  // Constructor con todas las variables
  public Pizza(String nombre, String tamaño, double precio) {
    this.nombre = nombre;
    this.tamaño = tamaño;
    this.precio = precio;
  }

  // Constructor con valores por defercto para precio y tamaño
  public Pizza(String nombre) {
    this.nombre = nombre;
    tamaño = "Mediana";
    precio = 9.95;
  }

  // Getters y setters
  public String getNombre() {
    return nombre;
  }

  public String getTamaño() {
    return tamaño;
  }

  public double getPrecio() {
    return precio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTamaño(String tamaño) {
    this.tamaño = tamaño;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  // Hash
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((tamaño == null) ? 0 : tamaño.hashCode());
    long temp;
    temp = Double.doubleToLongBits(precio);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  // Equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pizza other = (Pizza) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (tamaño == null) {
      if (other.tamaño != null)
        return false;
    } else if (!tamaño.equals(other.tamaño))
      return false;
    if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
      return false;
    return true;
  }

  // toString
  @Override
  public String toString() {
    return "Pizza [nombre=" + nombre + ", tamaño=" + tamaño + ", precio=" + precio + "]";
  }

}
