# Proyecto de Gestión NBA (Ejemplo Educativo Java)

Este proyecto es un ejemplo práctico diseñado para estudiantes de 1º de DAW (Desarrollo de Aplicaciones Web) para aprender conceptos fundamentales de Programación Orientada a Objetos (POO) en Java.

## 📂 Estructura del Proyecto

El proyecto sigue una arquitectura **MVC (Modelo-Vista-Controlador)** simplificada, organizando el código en paquetes según su responsabilidad:

- **`src.modelo_javabean`**: Contiene las clases que representan los datos (Modelos). Son clases sencillas con atributos privados, constructores y métodos getters/setters.
    - `Equipo.java`
    - `Jugador.java`
    - `Partido.java`
    - `Estadisticas.java`
- **`src.modelo_negocio`**: Contiene la lógica de la aplicación (Controlador/Lógica). Aquí es donde ocurren las operaciones "reales".
    - `GestionNBA.java`: Gestiona las listas de objetos y las operaciones de alta/baja.
- **`src.vista`**: Contiene la interfaz con el usuario.
    - `MenuNBA.java`: Un menú de consola para interactuar con la aplicación.
- **`src.pruebas`**: Contiene tests manuales.
    - `TestNBA.java`: Clase para probar el código rápidamente sin usar el menú.

---

## 📚 Conceptos de Java Utilizados

### 1. Clases y Objetos
- **Clase**: Es la plantilla (ej. `Jugador`). Define qué atributos y comportamientos tendrán los objetos.
- **Objeto**: Es una instancia de una clase (ej. `LeBron James` es un objeto de la clase `Jugador`).
- **Constructores**: Métodos especiales (`public Jugador(...)`) que se ejecutan al crear un objeto con `new`. Sirven para dar valores iniciales.

### 2. Modificadores de Acceso y Encapsulamiento
- **`private`**: Los atributos (como `nombre` o `edad`) se definen privados para protegerlos. Solo la propia clase puede tocarlos directamente.
- **`public`**: Los métodos se definen públicos para que otras clases puedan usarlos (ej. `getNombre()`, `ficharJugador()`).

### 3. Métodos (Estatícos vs Instancia)
- **Métodos de Instancia**: Necesitan un objeto creado para funcionar (ej. `equipo.getNombre()`). Actúan sobre los datos de *ese* objeto específico.
- **Métodos Estáticos (`static`)**: Pertenecen a la clase, no a un objeto. En `MenuNBA`, el `main` y sus métodos auxiliares son estáticos porque no creamos un objeto "Menu", simplemente ejecutamos código procedural.

### 4. Estructuras de Almacenamiento
- **`ArrayList<Tipo>`**: Usamos listas dinámicas en lugar de arrays normales (`[]`).
    - `add(objeto)`: Añade a la lista.
    - `remove(objeto)`: Borra de la lista.
    - `contains(objeto)`: Comprueba si existe (usa internamente `equals`).
    - `size()`: Devuelve el tamaño.

### 5. Estructuras de Control
- **`if / else`**: Para tomar decisiones (ej. verificar si un equipo existe antes de crearlo).
- **`switch`**: Para organizar el menú de opciones de forma limpia.
- **`for-each`**: Bucle para recorrer listas fácilmente:
    ```java
    // "Para cada Jugador j en la lista plantilla..."
    for (Jugador j : plantilla) {
        System.out.println(j);
    }
    ```
- **`do-while`**: Asegura que el menú se muestre al menos una vez y se repita hasta que el usuario elija "Salir".

### 6. Entrada de Datos (Scanner) y "El problema del nextLine()"
Cuando usamos `Scanner`, a veces pasa algo curioso al mezclar lectura de números y textos.
- `nextInt()` lee el número pero **deja el intro (\n) en el buffer**.
- Si hacemos un `nextLine()` justo después, este lee ese intro y parece que se salta la pregunta.
- **Solución**: Hacemos un `sc.nextLine()` extra "de limpieza" después de leer números.

### 7. Limpieza de Texto (`.trim()`)
Al pedir textos al usuario (como nombres de equpos), es facil equivocarse y poner un espacio al principio o al final (ej: " Lakers "). Esto hace que luego al buscar "Lakers" no coincida y falle.
- **`trim()`**: Es un método de la clase String que elimina los espacios en blanco sobrantes a ambos lados.
- **Uso**: `sc.nextLine().trim()` asegura que guardamos el texto "limpio", evitando errores tontos de coincidencia.

---

## 🔗 Relaciones entre Clases

### Asociación
Es una relación general donde "uno usa al otro". Por ejemplo, `GestionNBA` tiene una asociación con `Equipo` porque lo usa para guardarlo en la lista.

### Agregación y Composición
Son tipos específicos de asociación "Todo-Parte".

- **Agregación (Relación débil)**: El objeto contenedor tiene referencias a los objetos contenidos, pero estos pueden vivir fuera.
    - *Ejemplo*: `Equipo` tiene una lista de `Jugador`. Si borramos el equipo, los jugadores podrían teóricamente irse a otro (aunque en nuestro código simplificado al borrar equipo no "liberamos" a los jugadores explicitamente para otro equipo, conceptualmente es una agregación).
    - En el código, `Jugador` tiene un atributo `Equipo`. Esto es una **relación bidireccional**.

---

## 🛠️ Cómo ejecutarlo

1. Copila el proyecto desde la carpeta raíz:
   ```bash
   javac -d bin src/modelo_javabean/*.java src/modelo_negocio/*.java src/vista/*.java src/pruebas/*.java
   ```
2. Ejecuta el Menú interactivo:
   ```bash
   java -cp bin src.vista.MenuNBA
   ```
3. O ejecuta las pruebas automáticas:
   ```bash
   java -cp bin src.pruebas.TestNBA
   ```
