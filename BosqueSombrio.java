/**
 * Campo de Entrenamiento Bosque SOmbrio
 * Se asigna a los grupos segun la suma de habilidad de sus integrantes
 */
public class BosqueSombrio implements CampoEntrenamiento{
    
    /**
     * Nombre del campo
     */
    private String nombre = "Bosque Sombrio";

    /**
     * Descripcion del campo
     */
    private String descripcion = "Un bosque denso y con poca luz donde los ninjas aprenden a moverse sin ser vistos";

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
