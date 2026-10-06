/**
 * Campo de Entrenamiento Valle del Dragon
 * Se asigna a los grupos segun la suma de habilidad de sus integrantes
 */
public class ValleDelDragon implements CampoEntrenamiento{
    
    /**
     * Nombre del campo
     */
    private String nombre = "Valle del Dragon";

    /**
     * Descripcion del campo
     */
    private String descripcion = "Un valle amplio y seguro donde los ninjas novatos empiezan a entrenar";

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
