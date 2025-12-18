package A_02TiendaReparacion.modelos;

import java.util.ArrayList;

public class Tienda {

  // Atributos
  private String nombre;
  private ArrayList<Movil> inventario;

  // Métodos propios
  public void agregarMovil(Movil m) {
    this.inventario.add(m);
  }

  public void listarInventario() {

    for (Movil m : this.inventario) {
      System.out.println(m);
    }

  }

  public int getCantidadMoviles() {
    return this.inventario.size();
  }

  // Constructores
  public Tienda() {

  };

  public Tienda(String nombre) {
    this.nombre = nombre;
    this.inventario = new ArrayList<Movil>();
  }

  // Getters y Setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ArrayList<Movil> getInventario() {
    return inventario;
  }

  public void setInventario(ArrayList<Movil> inventario) {
    this.inventario = inventario;
  }

  // toString
  @Override
  public String toString() {
    return "Tienda [nombre=" + nombre + ", inventario=" + inventario + "]";
  }

}
