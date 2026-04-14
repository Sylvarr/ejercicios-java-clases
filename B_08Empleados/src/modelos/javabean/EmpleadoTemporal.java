package modelos.javabean;

import java.time.LocalDate;

import excepciones.EdadInvalidaExcepcion;
import excepciones.SalarioInvalidoExcepcion;

public class EmpleadoTemporal extends Empleado {

  private LocalDate fechaFinContrato;

  public EmpleadoTemporal(String nombre, int edad, double salario, LocalDate fechaFinContrato)
      throws SalarioInvalidoExcepcion, EdadInvalidaExcepcion {
    super(nombre, edad, salario);
    this.fechaFinContrato = fechaFinContrato;
  }

  @Override
  public String getTipoContrato() {
    return "Contrato temporal.";
  }

  public LocalDate getFechaFinContrato() {
    return fechaFinContrato;
  }

  public void setFechaFinContrato(LocalDate fechaFinContrato) {

    if (fechaFinContrato == null) {
      throw new IllegalArgumentException("La fecha no puede ser null");
    } else {
      this.fechaFinContrato = fechaFinContrato;
    }

  }

  @Override
  public String toString() {
    return super.toString() + "EmpleadoTemporal [fechaFinContrato=" + fechaFinContrato + "]";
  }

}
