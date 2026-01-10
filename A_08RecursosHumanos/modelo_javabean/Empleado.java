package A_08RecursosHumanos.modelo_javabean;

/**
 * Clase que representa un empleado de la empresa. Cada empleado pertenece a un
 * departamento y tiene un salario anual.
 */
public class Empleado {

  private int idEmpleado;
  private String nombre;
  private double salario;
  private Departamento departamento;

  /**
   * Constructor para crear un nuevo empleado.
   * 
   * @param idEmpleado   identificador único del empleado
   * @param nombre       nombre del empleado
   * @param salario      salario anual del empleado
   * @param departamento departamento al que pertenece el empleado
   */
  public Empleado(int idEmpleado, String nombre, double salario, Departamento departamento) {
    this.idEmpleado = idEmpleado;
    this.nombre = nombre;
    this.salario = salario;
    this.departamento = departamento;
  }

  /**
   * Calcula el salario mensual del empleado dividiendo el salario anual entre 14
   * pagas.
   * 
   * @return salario mensual del empleado
   */
  public double salarioMensual() {
    return this.salario / 14;
  }

  /**
   * Obtiene el identificador del empleado.
   * 
   * @return idEmpleado el identificador del empleado
   */
  public int getIdEmpleado() {
    return idEmpleado;
  }

  /**
   * Establece el identificador del empleado.
   * 
   * @param idEmpleado el nuevo identificador
   */
  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  /**
   * Obtiene el nombre del empleado.
   * 
   * @return nombre el nombre del empleado
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre del empleado.
   * 
   * @param nombre el nuevo nombre del empleado
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Obtiene el salario anual del empleado.
   * 
   * @return salario el salario anual
   */
  public double getSalario() {
    return salario;
  }

  /**
   * Establece el salario anual del empleado.
   * 
   * @param salario el nuevo salario anual
   */
  public void setSalario(double salario) {
    this.salario = salario;
  }

  /**
   * Obtiene el departamento del empleado.
   * 
   * @return departamento el departamento del empleado
   */
  public Departamento getDepartamento() {
    return departamento;
  }

  /**
   * Establece el departamento del empleado.
   * 
   * @param departamento el nuevo departamento
   */
  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", salario=" + salario + ", departamento="
        + departamento.getNombre() + "]";
  }

}
