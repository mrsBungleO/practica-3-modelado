/**
 * Es el producto de Factory Method, lo que las fabricas nos entregan
 * Lo unico que le pedimos a un campo de entrenamiento es que sepa decir 
 * su nombre y su descripcion, cada campo implementa esta interfaz
 */
public interface CampoEntrenamiento {
    /**
     * Devuelve el nombre del campo
     * @return nombre del campo
     */
    String getNombre();

    /**
     * Devuelve la descripcion del campo
     * @return descripcion del campo
     */
    String getDescripcion();
}

 
