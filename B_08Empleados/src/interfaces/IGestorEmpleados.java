package interfaces;

import modelos.javabean.Empleado;

public interface IGestorEmpleados {

  void agregarEmpleado(Empleado e);

  void listaEmpleados();

  Empleado buscarPorNombre(String nombre);

  double calcularSalarioMedio();

  void subirSalarioATodos(double porcentaje);

}
