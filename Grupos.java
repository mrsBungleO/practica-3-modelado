import java.util.Iterator;

/**
 * Clase que unifica a los dos grupos de ninjas que tenemos y obtiene a sus iteradores de una manera más limpia.
 */
public class Grupos{

    /**Grupo de ninjas aspirantes. */
    private GrupoAspirantes aspirantes;

    /**Grupo de ninjas voluntarios */
    private GrupoVoluntarios voluntarios;

    /**
     * Constructor de la clase Grupos para que tenga acceso a ambos grupos de ninjas.
     */
    public Grupos(){
        aspirantes= new GrupoAspirantes();
        voluntarios= new GrupoVoluntarios();
    }

    /**
     * Obtiene el iterador del grupo de ninjas aspirantes.
     * @return iterador del grupo de aspirantes.
     */
    public Iterator getIteradorAspirantes(){
        return aspirantes.getIterator();
    }

    /**
     * Obtiene el iterador del grupo de ninjas voluntarios.
     * @return iterador del grupo de voluntarios.
     */
    public Iterator getIteradorVoluntarios(){
        return voluntarios.getIterator();
    }

}