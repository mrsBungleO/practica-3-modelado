/**
 * Campo de Entrenamiento Montana Espiritual
 * Se asigna a los grupos segun la suma de habilidad de sus integrantes
 */
public class MontanaEspiritual implements CampoEntrenamiento{
    
    /**
     * Nombre del campo
     */
    private String nombre = "Montana Espiritual";

    /**
     * Descripcion del campo
     */
    private String descripcion = "Una montaña sagrada de clima extremo donde solo entrenan los ninjas con mayor habilidad";

    /**
     * Devuelve el nombre del campo
     * @return nombre del campo
     */
    @Override 
    public String getNombre(){
        return nombre;
    }

    /**
     * Devuelve la descripcion del campo
     * @return la descripcion del campo
     */
    @Override 
    public String getDescripcion(){
        return descripcion;
    }

}
