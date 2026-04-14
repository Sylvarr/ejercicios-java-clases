package modelos.dao;

import java.util.ArrayList;

import excepciones.EmpleadoNoEncontradoExcepcion;
import excepciones.SalarioInvalidoExcepcion;
import interfaces.IGestorEmpleados;
import modelos.javabean.Empleado;

public class GestorEmpleados implements IGestorEmpleados {

  private ArrayList<Empleado> listaEmpleados;

  public GestorEmpleados() {
    listaEmpleados = new ArrayList<>();
  }

  @Override
  public void agregarEmpleado(Empleado e) {
    if (e == null) {
      throw new IllegalArgumentException("El empleado no puede ser null");
    } else {
      listaEmpleados.add(e);
    }

  }

  @Override
  public void listaEmpleados() {
    for (Empleado empleado : listaEmpleados) {
      System.out.println(empleado.toString());
    }
  }

  @Override
  public Empleado buscarPorNombre(String nombre) {
    for (Empleado empleado : listaEmpleados) {
      if (empleado.getNombre().contains(nombre)) {
        return empleado;
      }
    }
    throw new EmpleadoNoEncontradoExcepcion("No existe: " + nombre);
  }

  @Override
  public double calcularSalarioMedio() {
    if (listaEmpleados.isEmpty()) {
      throw new IllegalStateException("No hay empleados registrados");
    }

    double total = 0.0;
    for (Empleado empleado : listaEmpleados) {
      total += empleado.getSalario();
    }
    return total / listaEmpleados.size();
  }

  @Override
  public void subirSalarioATodos(double porcentaje) {
    if (porcentaje < 0) {
      throw new IllegalArgumentException("El porcentaje no puede ser negativo");
    }

    for (Empleado empleado : listaEmpleados) {
      double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
      try {
        empleado.setSalario(nuevoSalario);
      } catch (SalarioInvalidoExcepcion e) {
        System.out.println("Error al subir salario: " + e.getMessage());
      }
    }
  }
}
