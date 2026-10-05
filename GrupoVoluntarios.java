import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase que crea y almacena a los ninjas voluntarios en un array list.
 */
public class GrupoVoluntarios{

    /**Array list donde se almacenan los ninjas voluntarios. */
    private ArrayList<NinjaVoluntario> voluntarios= new ArrayList<>();

    /**
     * Constructor de un grupo de ninjas voluntarios. Crea a los voluntarios y los almacena en el array list.
     */
    public GrupoVoluntarios(){
        try{
            NinjaVoluntario v1= new NinjaVoluntario("Mike", 24, Clan.FUCHIHA, 4, Rango.GENIN);
            NinjaVoluntario v2= new NinjaVoluntario("James", 25, Clan.OSOMAKI, 5, Rango.CHUNIN);
            NinjaVoluntario v3= new NinjaVoluntario("Leslie", 22, Clan.FUCHIHA, 5, Rango.JONIN);
            NinjaVoluntario v4= new NinjaVoluntario("Sandra", 23, Clan.MORTALIKA, 4, Rango.GENIN);
            NinjaVoluntario v5= new NinjaVoluntario("Phil", 24, Clan.NACA, 6, Rango.JONIN);

            voluntarios.add(v1);
            voluntarios.add(v2);
            voluntarios.add(v3);
            voluntarios.add(v4);
            voluntarios.add(v5);
        } catch(IllegalArgumentException e){
            System.out.println("Error al registrar a un voluntario: " + e.getMessage());
        }
        
    }

    /**
     * Devuelve el iterador del array list que ya contiene java.
     * @return el iterador de array list voluntarios.
     */
    public Iterator getIterator(){
        return voluntarios.iterator();
    }
}