package modelos.javabean;

import excepciones.EdadInvalidaExcepcion;
import excepciones.SalarioInvalidoExcepcion;

public abstract class Empleado {

  protected String nombre;
  protected int edad;
  protected double salario;

  public Empleado() {
  }

  public Empleado(String nombre, int edad, double salario) throws SalarioInvalidoExcepcion, EdadInvalidaExcepcion {
    this.nombre = nombre;
    setEdad(edad);
    setSalario(salario);
  }

  protected abstract String getTipoContrato();

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) throws EdadInvalidaExcepcion {

    if (edad >= 18) {
      this.edad = edad;
    } else {
      throw new EdadInvalidaExcepcion("Es necesario que la persona sea mayor de edad.");
    }

  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) throws SalarioInvalidoExcepcion {

    if (salario > 0) {
      this.salario = salario;
    } else {
      throw new SalarioInvalidoExcepcion("El salario debe ser mayor que 0. Valor recibido: " + salario);
    }

  }

  @Override
  public String toString() {
    return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
  }

}
