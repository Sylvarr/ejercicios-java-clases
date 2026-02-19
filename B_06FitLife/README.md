# Ejercicio: FitLife — Sistema de gestión de entrenamientos

## Contexto

Vas a modelar el sistema de registro de actividades de un gimnasio llamado **FitLife**.
Los socios del gimnasio pueden realizar dos tipos de actividades: **clases dirigidas** por un profesor o **entrenamientos libres** en distintas zonas del gimnasio. Cada vez que un socio realiza una actividad se crea una **sesión** que queda registrada en el sistema.

Tu tarea es implementar todas las clases, interfaces y excepciones partiendo de cero siguiendo las especificaciones de este documento.

---

## Estructura de paquetes

```
src/
├── excepciones/
│   ├── ActividadInvalidaException.java
│   ├── FechaInvalidaException.java
│   ├── SesionInvalidaException.java
│   └── SocioInvalidoException.java
├── interfaces/
│   ├── IEntrenable.java
│   └── IFitLifeDAO.java
├── modelos/
│   ├── javabean/
│   │   ├── Socio.java
│   │   ├── Actividad.java          ← clase abstracta
│   │   ├── ClaseDirigida.java
│   │   ├── EntrenamientoLibre.java
│   │   └── Sesion.java
│   └── DAO/
│       └── FitLifeDAOImpl.java
└── test/
    ├── ClaseDirigidaTest.java
    ├── EntrenamientoLibreTest.java
    ├── SesionTest.java
    └── FitLifeDAOImplTest.java
```

---

## Parte 1 — Excepciones personalizadas

Crea cuatro excepciones **comprobadas** (checked) en el paquete `excepciones`. Todas extienden `Exception`.

| Clase | Constructor |
|---|---|
| `ActividadInvalidaException` | `(String mensaje)` |
| `FechaInvalidaException` | `(String mensaje)` |
| `SesionInvalidaException` | `()` y `(String mensaje)` |
| `SocioInvalidoException` | `(String mensaje)` |

> Cada constructor simplemente llama a `super(mensaje)` (o `super()` en el caso sin argumentos).

---

## Parte 2 — Interfaz `IEntrenable`

Paquete: `interfaces`

Define el contrato que debe cumplir cualquier actividad física del sistema.

```
IEntrenable
├── double calcularCaloriasQuemadas(int minutos)
└── String obtenerNivelIntensidad()
```

---

## Parte 3 — Clase abstracta `Actividad`

Paquete: `modelos.javabean`
Implementa: `IEntrenable`

### Atributos (todos `protected`)

| Atributo | Tipo |
|---|---|
| `idActividad` | `String` |
| `nombreActividad` | `String` |
| `caloriasPorMinutosBase` | `double` |

### Constructor

```
Actividad(String idActividad, String nombreActividad, double caloriasPorMinutosBase)
```

### Métodos

- Getter y setter para cada atributo.
- `hashCode()` y `equals()`: la igualdad se basa **únicamente** en `idActividad`.
- `toString()`: incluye los tres atributos.
- Los dos métodos de `IEntrenable` quedan **sin implementar** (abstractos), delegando la responsabilidad en las subclases.

---

## Parte 4 — Clase `ClaseDirigida`

Paquete: `modelos.javabean`
Extiende: `Actividad`

### Atributos propios

| Atributo | Tipo | Descripción |
|---|---|---|
| `nombreProfesor` | `String` | Profesor que imparte la clase |
| `requiereReserva` | `boolean` | Si la clase necesita reserva previa |

### Constructor

```
ClaseDirigida(String idActividad, String nombreActividad, double caloriasPorMinutosBase,
              String nombreProfesor, boolean requiereReserva)
```

### Implementación de `IEntrenable`

**`calcularCaloriasQuemadas(int minutos)`**
Las clases dirigidas tienen un bonus de motivación grupal de **50 kcal fijas**.
Fórmula: `(caloriasPorMinutosBase × minutos) + 50`

> Ejemplo: 10 cal/min × 60 min + 50 = **650 kcal**

**`obtenerNivelIntensidad()`**
- Si `requiereReserva` → devuelve `"ALTO"`
- Si no → devuelve `"MEDIO"`

### Otros métodos

- Getter y setter para `nombreProfesor` y `requiereReserva`.
- `toString()`: añade al `toString()` del padre los atributos propios.

---

## Parte 5 — Clase `EntrenamientoLibre`

Paquete: `modelos.javabean`
Extiende: `Actividad`

### Atributo propio

| Atributo | Tipo | Descripción |
|---|---|---|
| `zonaGimnasio` | `String` | Zona del gimnasio donde se realiza |

### Constructor

```
EntrenamientoLibre(String idActividad, String nombreActividad, double caloriasPorMinutosBase,
                   String zonaGimnasio)
```

### Implementación de `IEntrenable`

**`calcularCaloriasQuemadas(int minutos)`**
Sin bonus. Fórmula directa: `caloriasPorMinutosBase × minutos`

> Ejemplo: 10 cal/min × 60 min = **600 kcal**

**`obtenerNivelIntensidad()`**
- Si `zonaGimnasio` es `"Crossfit"` → devuelve `"ALTO"`
- Cualquier otra zona → devuelve `"VARIABLE"`

### Otros métodos

- Getter y setter para `zonaGimnasio`.
- `toString()`: añade al `toString()` del padre el atributo propio.

---

## Parte 6 — Clase `Socio`

Paquete: `modelos.javabean`

### Atributos

| Atributo | Tipo |
|---|---|
| `idSocio` | `String` |
| `nombre` | `String` |

### Constructor

```
Socio(String idSocio, String nombre)
```

### Métodos

- Getter y setter para cada atributo.
- `hashCode()` y `equals()`: la igualdad se basa **únicamente** en `idSocio`.
- `toString()`: incluye ambos atributos.

---

## Parte 7 — Clase `Sesion`

Paquete: `modelos.javabean`

Una sesión une a un socio con una actividad en un momento concreto.

### Atributos

| Atributo | Tipo |
|---|---|
| `fecha` | `LocalDate` |
| `socio` | `Socio` |
| `actividadRealizada` | `Actividad` |
| `duracionMinutos` | `int` |

### Constructor

```
Sesion(LocalDate fecha, Socio socio, Actividad actividadRealizada, int duracionMinutos)
    throws SocioInvalidoException, ActividadInvalidaException, FechaInvalidaException
```

> El constructor debe delegar la asignación de `socio`, `actividadRealizada` y `fecha` en sus respectivos setters para reutilizar las validaciones.

### Setters con validación

Cada uno lanza su excepción correspondiente si recibe `null`:

| Setter | Lanza |
|---|---|
| `setFecha(LocalDate)` | `FechaInvalidaException` |
| `setSocio(Socio)` | `SocioInvalidoException` |
| `setActividadRealizada(Actividad)` | `ActividadInvalidaException` |

El setter de `duracionMinutos` no necesita validación.

### Otros métodos

- Getter para cada atributo.
- `toString()`: muestra la fecha, el nombre del socio, el nombre de la actividad y la duración.

---

## Parte 8 — Interfaz `IFitLifeDAO`

Paquete: `interfaces`

Define las operaciones disponibles sobre el repositorio de sesiones.

```java
void registrarSesion(Sesion sesion) throws SesionInvalidaException;

Set<Socio> obtenerSociosActivos();

double calcularCaloriasTotalesEnClasesDirigidas();

Map<String, Long> contarClasesPorProfesor();

Map<LocalDate, List<Sesion>> agruparEntrenamientosLibresPorFecha();

List<Sesion> sesionesExtremas(int minutosMinimos);
```

---

## Parte 9 — Clase `FitLifeDAOImpl`

Paquete: `modelos.DAO`
Implementa: `IFitLifeDAO`

Almacena las sesiones en un `ArrayList<Sesion>` privado que se inicializa en el constructor.

### Implementación de cada método

**`registrarSesion(Sesion sesion)`**
Si `sesion` es `null` → lanza `SesionInvalidaException`.
Si no → añade la sesión a la lista.

**`obtenerSociosActivos()`**
Recorre todas las sesiones y devuelve un `Set<Socio>` con los socios únicos.
*(La unicidad la garantiza el `equals`/`hashCode` de `Socio`.)*

**`calcularCaloriasTotalesEnClasesDirigidas()`**
Suma las calorías de todas las sesiones cuya actividad sea una `ClaseDirigida`.
Usa `calcularCaloriasQuemadas` con la duración de cada sesión.

**`contarClasesPorProfesor()`**
Devuelve un `Map<String, Long>` donde la clave es el nombre del profesor y el valor es el número total de clases que ha impartido.

**`agruparEntrenamientosLibresPorFecha()`**
Filtra las sesiones de tipo `EntrenamientoLibre` y las agrupa en un `Map<LocalDate, List<Sesion>>` por fecha.

**`sesionesExtremas(int minutosMinimos)`**
Devuelve una lista con las sesiones que cumplen **ambas** condiciones:
1. Su duración es **estrictamente mayor** que `minutosMinimos`.
2. El nivel de intensidad de su actividad es `"ALTO"`.

---

## Parte 10 — Tests

Los tests están escritos con **JUnit 5**. Crea las cuatro clases en el paquete `test` y asegúrate de que todos pasan en verde.

### `ClaseDirigidaTest`

Prepara en `@BeforeEach` dos instancias:
- `claseConReserva`: id `"C01"`, nombre `"Zumba"`, 10.0 cal/min, profesor `"ProfeA"`, `requiereReserva = true`
- `claseSinReserva`: id `"C02"`, nombre `"Pilates"`, 8.0 cal/min, profesor `"ProfeB"`, `requiereReserva = false`

| Test | Qué comprueba |
|---|---|
| `testCalcularCaloriasQuemadas` | `claseConReserva.calcularCaloriasQuemadas(60)` → `650.0` |
| `testObtenerNivelIntensidad_conReserva` | `claseConReserva.obtenerNivelIntensidad()` → `"ALTO"` |
| `testObtenerNivelIntensidad_sinReserva` | `claseSinReserva.obtenerNivelIntensidad()` → `"MEDIO"` |

---

### `EntrenamientoLibreTest`

Prepara en `@BeforeEach` dos instancias:
- `entrenamientoRunning`: id `"B002"`, nombre `"Running"`, 10 cal/min, zona `"Cardio"`
- `entrenamientoCrossfit`: id `"B003"`, nombre `"WOD"`, 15 cal/min, zona `"Crossfit"`

| Test | Qué comprueba |
|---|---|
| `testCalcularCaloriasQuemadas` | `entrenamientoRunning.calcularCaloriasQuemadas(60)` → `600.0` |
| `testObtenerNivelIntensidad_EsCrossfit` | `entrenamientoCrossfit.obtenerNivelIntensidad()` → `"ALTO"` |
| `testObtenerNivelIntensidad_NoEsCrossfit` | `entrenamientoRunning.obtenerNivelIntensidad()` → `"VARIABLE"` |

---

### `SesionTest`

No necesita `@BeforeEach`.

| Test | Qué comprueba |
|---|---|
| `testConstructor_LanzaExcepcion_SiSocioEsNull` | `new Sesion(LocalDate.now(), null, actividadValida, 60)` lanza `SocioInvalidoException` |
| `testConstructor_LanzaExcepcion_SiActividadEsNull` | `new Sesion(LocalDate.now(), socioValido, null, 60)` lanza `ActividadInvalidaException` |

---

### `FitLifeDAOImplTest`

El `@BeforeEach` inicializa el estado común:

```
dao          → FitLifeDAOImpl vacío
socio1       → Socio("001A", "Pencho")
socio2       → Socio("002A", "Roberto")
clase1       → ClaseDirigida("A001", "Pilates", 10, "Juan", true)
libre1       → EntrenamientoLibre("B001", "Running", 15, "Cardio")

sesion1 → fecha: hoy,         socio: socio1, actividad: clase1,  duración: 60 min
sesion2 → fecha: hoy - 3 días, socio: socio1, actividad: libre1,  duración: 90 min
sesion3 → fecha: hoy - 1 día,  socio: socio2, actividad: clase1,  duración: 45 min
```

Las tres sesiones se registran en el DAO.

| Test | Qué comprueba |
|---|---|
| `testObtenerSociosActivos` | El set de socios tiene tamaño **2** |
| `testCalcularCaloriasTotalesEnClasesDirigidas` | El total de kcal de clases dirigidas es **1150.0** — *¿por qué ese valor? Calcula con la fórmula.* |
| `testContarClasesPorProfesor` | El profesor `"Juan"` aparece **2** veces en el mapa |
| `testAgruparEntrenamientosLibresPorFecha` | La lista de `LocalDate.now().minusDays(3)` tiene tamaño **1** |
| `testSesionesExtremas` | Con `minutosMinimos = 5`, se obtienen **2** sesiones extremas |

---

## Diagrama de clases (resumen)

```
            «interface»                    «interface»
            IEntrenable                    IFitLifeDAO
           /           \                       |
    ClaseDirigida  EntrenamientoLibre    FitLifeDAOImpl
           \           /
           Actividad  (abstracta)
                |
            Sesion ──── Socio
```

---

## Pistas finales

- Recuerda que `instanceof` te permite comprobar de qué subtipo es una `Actividad` en el DAO.
- Para los `Map`, `getOrDefault` puede ahorrarte un `if` al acumular contadores.
- El test `testSesionesExtremas` usa `minutosMinimos = 5`. Repasa qué sesiones superan 5 minutos **y** tienen intensidad `"ALTO"` para entender el resultado esperado.
- La gestión de excepciones del constructor de `Sesion` no requiere `try/catch`: simplemente declara el `throws` correspondiente.
