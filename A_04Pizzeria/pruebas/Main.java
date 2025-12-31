package A_04Pizzeria.pruebas;

import A_04Pizzeria.modelos.Pizza;

public class Main {

  public static void main(String[] args) {

    // Creamos dos pizzas para probar los dos constructores
    Pizza pizza1 = new Pizza("Cuatro estaciones", "grande", 10.05);
    Pizza pizza2 = new Pizza("Diavolo");

    // Podemos ver que los valores por defecto funcionan como deben
    System.out.println("Primera pizza usando constructor normal: " + pizza1);
    System.out.println("Segunda pizza usando constructor con variables por defecto: " + pizza2);

    // Creamos dos pizzas identicas
    Pizza p1 = new Pizza("Margarita", "Mediana", 9.95);
    Pizza p2 = new Pizza("Margarita", "Mediana", 9.95);

    // Probamos la igualdad estricta. Siempre devuelve false ya que
    if (p1 == p2) {
      System.out.println("Son iguales!");
    } else {
      System.out.println("No son iguales! Usando ==");
    }

    if (p1.equals(p2)) {
      System.out.println("Son iguales! Con equals.");
    } else {
      System.out.println("No son iguales!");
    }
  }

}
