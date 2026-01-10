package A_08RecursosHumanos.modelo_negocio;

import A_08RecursosHumanos.modelo_javabean.Departamento;
import A_08RecursosHumanos.modelo_javabean.Empleado;
import java.util.ArrayList;

/**
 * Clase que representa una empresa con empleados organizados en departamentos.
 * Permite gestionar la plantilla de empleados y buscar empleados por
 * departamento.
 */
public class Empresa {

  private String nombreEmpresa;
  private ArrayList<Empleado> plantilla;
  private ArrayList<Departamento> departamentos;

  /**
   * Método privado que carga los datos iniciales de la empresa. Crea dos
   * departamentos (IT y Ventas) y tres empleados de ejemplo.
   */
  private void cargarDatos() {
    Departamento depIt = new Departamento(1, "IT");
    Departamento depVtas = new Departamento(2, "Ventas");

    departamentos.add(depIt);
    departamentos.add(depVtas);

    Empleado pencho = new Empleado(1, "Pencho", 36000, depIt);
    Empleado jorge = new Empleado(2, "Jorge", 38000, depVtas);
    Empleado roberto = new Empleado(3, "Roberto", 43000, depIt);

    plantilla.add(pencho);
    plantilla.add(jorge);
    plantilla.add(roberto);
  }

  /**
   * Constructor para crear una nueva empresa. Inicializa la plantilla y
   * departamentos, y carga los datos por defecto.
   * 
   * @param nombreEmpresa nombre de la empresa
   */
  public Empresa(String nombreEmpresa) {
    this.nombreEmpresa = nombreEmpresa;
    this.departamentos = new ArrayList<>();
    this.plantilla = new ArrayList<>();
    cargarDatos();
  }

  /**
   * Busca todos los empleados que pertenecen a un departamento específico.
   * 
   * @param nombreDep nombre del departamento a buscar
   * @return lista de empleados del departamento especificado
   */
  public ArrayList<Empleado> buscarPorDepartamento(String nombreDep) {
    ArrayList<Empleado> empleadosDep = new ArrayList<>();

    for (Empleado emp : plantilla) {

      if (emp.getDepartamento().getNombre().equals(nombreDep)) {
        empleadosDep.add(emp);
      }

    }

    return empleadosDep;

  }

  /**
   * Obtiene el nombre de la empresa.
   * 
   * @return nombreEmpresa el nombre de la empresa
   */
  public String getNombreEmpresa() {
    return nombreEmpresa;
  }

}
