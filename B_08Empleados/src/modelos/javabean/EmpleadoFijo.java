package modelos.javabean;

import excepciones.AniosEnEmpresaInvalidosException;
import excepciones.EdadInvalidaExcepcion;
import excepciones.SalarioInvalidoExcepcion;

public class EmpleadoFijo extends Empleado {

  private int aniosEnEmpresa;

  public EmpleadoFijo(String nombre, int edad, double salario, int aniosEnEmpresa)
      throws SalarioInvalidoExcepcion, EdadInvalidaExcepcion {
    super(nombre, edad, salario);
    this.aniosEnEmpresa = aniosEnEmpresa;
  }

  @Override
  public String getTipoContrato() {
    return "Contrato Indefinido.";
  }

  public int getAniosEnEmpresa() {
    return aniosEnEmpresa;
  }

  public void setAniosEnEmpresa(int aniosEnEmpresa) throws AniosEnEmpresaInvalidosException {
    if (aniosEnEmpresa > 0) {
      this.aniosEnEmpresa = aniosEnEmpresa;
    } else {
      throw new AniosEnEmpresaInvalidosException("El número ha de ser positivo");
    }
  }

  @Override
  public String toString() {
    return super.toString() + "EmpleadoFijo [aniosEnEmpresa=" + aniosEnEmpresa + "]";
  }

}
