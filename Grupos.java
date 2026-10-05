import java.util.Iterator;

public class Grupos{

    private GrupoAspirantes aspirantes;
    private GrupoVoluntarios voluntarios;

    public Grupos(){
        aspirantes= new GrupoAspirantes();
        voluntarios= new GrupoVoluntarios();
    }

    public Iterator getIteradorAspirantes(){
        return aspirantes.getIterator();
    }

    public Iterator getIteradorVoluntarios(){
        return voluntarios.getIterator();
    }

}