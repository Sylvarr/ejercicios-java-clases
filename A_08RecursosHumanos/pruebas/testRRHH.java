package A_08RecursosHumanos.pruebas;

import A_08RecursosHumanos.modelo_negocio.Empresa;

/**
 * Clase de prueba para el sistema de Recursos Humanos. Prueba las
 * funcionalidades básicas de búsqueda de empleados por departamento.
 */
public class testRRHH {

  private static Empresa miEmpresa;

  static {
    miEmpresa = new Empresa("R&P Incorporated");
  }

  /**
   * Método principal que ejecuta las pruebas del sistema.
   * 
   * @param args argumentos de línea de comandos (no utilizado)
   */
  public static void main(String[] args) {

    System.out.println(miEmpresa.buscarPorDepartamento("IT"));

  }

}
