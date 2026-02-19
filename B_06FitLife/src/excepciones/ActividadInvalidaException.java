package excepciones;

/**
 * Excepción lanzada cuando se proporciona una actividad no válida,
 * por ejemplo cuando el objeto {@code Actividad} es {@code null}.
 */
public class ActividadInvalidaException extends Exception {

  /**
   * Construye la excepción con el mensaje de error indicado.
   *
   * @param mensaje Descripción del motivo por el que la actividad es inválida.
   */
  public ActividadInvalidaException(String mensaje) {
    super(mensaje);
  }
}
