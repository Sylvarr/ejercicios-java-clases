package A_05Banco.pruebas;

import A_05Banco.modelos.Banco;
import A_05Banco.modelos.CuentaBancaria;

public class SimuladorBanco {

  public static void main(String[] args) {

    Banco santander = new Banco("Satantander");

    System.out.println(santander);

    CuentaBancaria pencho = new CuentaBancaria("Pencho", 1000);

    CuentaBancaria javier = new CuentaBancaria("Javier");

    javier.retirar(50);
    javier.ingresar(100);

    santander.abrirCuenta(pencho);
    santander.abrirCuenta(javier);
    santander.abrirCuenta(pencho);
    santander.mostrarCuentas();

  }

}
