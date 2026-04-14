package test;

import excepciones.EdadInvalidaExcepcion;
import excepciones.SalarioInvalidoExcepcion;
import modelos.dao.GestorEmpleados;
import modelos.javabean.Empleado;
import modelos.javabean.EmpleadoFijo;

public class app {

  public static void main(String[] args) {

    GestorEmpleados gestorEmpleados = new GestorEmpleados();

    try {

      Empleado e = new EmpleadoFijo("Juan", 25, -500, 3);

    } catch (SalarioInvalidoExcepcion e) {
      System.out.println("Error: " + e.getMessage());
    } catch (EdadInvalidaExcepcion e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

}
