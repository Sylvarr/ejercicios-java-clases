package A_05Banco.modelos;

import java.util.ArrayList;

public class Banco {

  private String nombre;
  private ArrayList<CuentaBancaria> listaCuentas;

  public Banco(String nombre) {
    this.nombre = nombre;
    this.listaCuentas = new ArrayList<CuentaBancaria>();
  }

  public void abrirCuenta(CuentaBancaria c) {
    if (listaCuentas.contains(c)) {
      System.out.println("Error. El cliente ya tiene cuenta.");
    } else {
      listaCuentas.add(c);
    }
  }

  public void mostrarCuentas() {

    for (CuentaBancaria c : this.listaCuentas) {
      System.out.println(c);
    }

  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    return "Banco [nombre=" + nombre + ", listaCuentas=" + listaCuentas + "]";
  }

}
