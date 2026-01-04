package A_07Concesionario.pruebas;

import A_07Concesionario.modelos.Coche;
import A_07Concesionario.modelos.Concesionario;
import A_07Concesionario.modelos.Moto;

public class TestConcesionario {

  public static void main(String[] args) {

    Concesionario tienda = new Concesionario();

    Coche toyota = new Coche("Toyota", "Corolla", 2000, 4);

    Coche toyota2 = new Coche("Toyota", "Corolla", 2000, 4);

    Moto yamaha = new Moto("Yamaha", "MT-07", 7500, 689);

    Coche mustang = new Coche("Ford", "Mustang", 45000, 2);

    tienda.agregarVehiculo(toyota);
    tienda.agregarVehiculo(toyota2);
    tienda.agregarVehiculo(yamaha);
    tienda.agregarVehiculo(mustang);
    tienda.mostrarTodo();

  }

}
