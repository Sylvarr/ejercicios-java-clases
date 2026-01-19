package src.pruebas;

import src.modelo_negocio.GestionNBA;

public class TestGestion {
  public static void main(String[] args) {
    GestionNBA gestion = new GestionNBA();

    System.out.println("TEST 1: Mostrar equipos sin añadir nada.");
    gestion.mostrarNombresEquipos();

    System.out.println("\nTEST 2: Añadir equipo y mostrar.");
    gestion.altaEquipo("Lakers", "LA", "West", "Pacific");
    gestion.mostrarNombresEquipos();
  }
}
