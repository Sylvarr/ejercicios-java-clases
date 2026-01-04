package A_07Concesionario.modelos;

import java.util.ArrayList;

/**
 * Clase que gestiona el inventario de vehículos de un concesionario. Permite
 * agregar, quitar y mostrar vehículos.
 */
public class Concesionario {

  private ArrayList<Vehiculo> inventario;

  /**
   * Constructor que inicializa el inventario vacío.
   */
  public Concesionario() {
    this.inventario = new ArrayList<>();
  }

  /**
   * Añade un vehículo al inventario si no existe ya.
   * 
   * @param v Vehículo a añadir
   */
  public void agregarVehiculo(Vehiculo v) {
    if (inventario.contains(v)) {
      System.out.println("Error: El vehículo " + v.toString() + " ya está en inventario.");
    } else {
      inventario.add(v);
      System.out.println("Vehículo añadido correctamente: ");
    }
  }

  /**
   * Elimina un vehículo del inventario.
   * 
   * @param v Vehículo a eliminar
   */
  public void quitarVehiculo(Vehiculo v) {
    inventario.remove(v);
  }

  /**
   * Muestra los detalles de todos los vehículos en el inventario.
   */
  public void mostrarTodo() {

    for (Vehiculo v : inventario) {

      v.mostrarDetalles();

    }

  }

  @Override
  public String toString() {
    return "Concesionario [inventario=" + inventario + "]";
  }

}
