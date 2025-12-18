package A_01PrimerEjercicio.pruebas;

import A_01PrimerEjercicio.modelos.Cliente;
import A_01PrimerEjercicio.modelos.Direccion;

public class Main {

  public static void main(String[] args) {

    // Creamos un objeto a partir del molde de Direccion
    Direccion miCasa = new Direccion("Calle Gran Via, 20", "Madrid");

    // Creamos un objeto a partir del molde de Cliente el cual contiene Direccion
    // como variable interna.
    Cliente cliente1 = new Cliente("Pencho", 36, miCasa);

    // toString
    System.out.println(cliente1);

    // Como accedemos a la ciudad del cliente ?
    System.out.println("El cliente vive en : " + cliente1.getDireccion().getCiudad());

  }

}
