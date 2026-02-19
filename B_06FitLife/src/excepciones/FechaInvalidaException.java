package excepciones;

/**
 * Excepción lanzada cuando se proporciona una fecha no válida,
 * por ejemplo cuando el objeto {@code LocalDate} es {@code null}.
 */
public class FechaInvalidaException extends Exception {

  /**
   * Construye la excepción con el mensaje de error indicado.
   *
   * @param mensaje Descripción del motivo por el que la fecha es inválida.
   */
  public FechaInvalidaException(String mensaje) {
    super(mensaje);
  }

}
