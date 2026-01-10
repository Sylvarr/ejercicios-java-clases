package A_08RecursosHumanos.modelo_javabean;

/**
 * Clase que representa un departamento de la empresa. Cada departamento tiene
 * un identificador único y un nombre.
 */
public class Departamento {

  private int idDep;
  private String nombre;

  /**
   * Constructor para crear un nuevo departamento.
   * 
   * @param idDep  identificador único del departamento
   * @param nombre nombre del departamento
   */
  public Departamento(int idDep, String nombre) {
    this.idDep = idDep;
    this.nombre = nombre;
  }

  /**
   * Obtiene el identificador del departamento.
   * 
   * @return idDep el identificador del departamento
   */
  public int getIdDep() {
    return idDep;
  }

  /**
   * Establece el identificador del departamento.
   * 
   * @param idDep el nuevo identificador
   */
  public void setIdDep(int idDep) {
    this.idDep = idDep;
  }

  /**
   * Obtiene el nombre del departamento.
   * 
   * @return nombre el nombre del departamento
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre del departamento.
   * 
   * @param nombre el nuevo nombre del departamento
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Departamento [idDep=" + idDep + ", nombre=" + nombre + "]";
  }

}
