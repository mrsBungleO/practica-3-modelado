/**
 * Clase base de los campos de entrenamiento. Guarda el nombre y la
 * descripcion que todos los campos tienen en comun, 
 * cada campo concreto los define en su constructor
 */
public abstract class CampoEntrenamiento {
    protected String nombre;
    protected String descripcion;
    

    /**
     * @param nombre nombre del campo
     * @param descripcion breve descripcion del lugar
     */
    public CampoEntrenamiento(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * @return nombre del campo
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @return descripcion del campo
     */
    public String getDescripcion(){
        return descripcion;
    }
}
