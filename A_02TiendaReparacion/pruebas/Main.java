package A_02TiendaReparacion.pruebas;

import A_02TiendaReparacion.modelos.Bateria;
import A_02TiendaReparacion.modelos.Movil;
import A_02TiendaReparacion.modelos.Tienda;

public class Main {

  public static void main(String[] args) {

    // Creamos bateria
    Bateria bateria = new Bateria(10500, "Samsung");

    // Creamos 3 Moviles
    Movil movil = new Movil("Samsung", 1200, bateria);
    Movil movil2 = new Movil("Sony", 1300, bateria);
    Movil movil3 = new Movil("Alcatel", 800, bateria);

    // Creamos una tienda
    Tienda tienda = new Tienda("Móviles Paco");

    // Agregamos 3 moviles
    tienda.agregarMovil(movil);
    tienda.agregarMovil(movil2);
    tienda.agregarMovil(movil3);

    // Sacamos cuantos moviles hay en total, y las especificaciones de cada uno
    System.out.println("En esta tienda hay " + tienda.getCantidadMoviles() + " moviles.");
    tienda.listarInventario();

  }

}
