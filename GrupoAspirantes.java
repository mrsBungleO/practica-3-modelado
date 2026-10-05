import java.util.Hashtable;
import java.util.Iterator;

/**
 * Clase que se encarga de crear y almacenar a los ninjas aspirantes en una tabla Hash.
 */
public class GrupoAspirantes{
    
    /**Tabla hash donde se almacenan a los ninjas aspirantes. */
    private Hashtable<String,NinjaAspirante> aspirantes= new Hashtable<>();

    /**
     * Constructor de un grupo de ninjas aspirantes. Crea a los aspirantes y los almacena en la tabla Hash.
     */
    public GrupoAspirantes(){
        try{
            NinjaAspirante a1= new NinjaAspirante("Trevor", 23, Clan.NACA, 3);
            NinjaAspirante a2= new NinjaAspirante("Cristina", 25, Clan.AKIPICHI, 3);
            NinjaAspirante a3= new NinjaAspirante("Dimebag", 24, Clan.MORTALIKA, 3);
            NinjaAspirante a4= new NinjaAspirante("Memo", 26, Clan.FUCHIHA, 2);
            NinjaAspirante a5= new NinjaAspirante("Dafne", 25, Clan.OSOMAKI, 1);
            NinjaAspirante a6= new NinjaAspirante("Vinnie", 26, Clan.MORTALIKA, 2);
            NinjaAspirante a7= new NinjaAspirante("Rex", 24, Clan.AKIPICHI, 1);
            NinjaAspirante a8= new NinjaAspirante("Frank", 27, Clan.NACA, 3);
            NinjaAspirante a9= new NinjaAspirante("Varg", 24, Clan.OSOMAKI, 2);
            NinjaAspirante a10= new NinjaAspirante("Bruce", 26, Clan.AKIPICHI, 3);

            aspirantes.put("Retrovertigo", a1);
            aspirantes.put("Suckerphilia", a2);
            aspirantes.put("Floods", a3);
            aspirantes.put("Bluish", a4);
            aspirantes.put("Dolce", a5);
            aspirantes.put("Becoming", a6);
            aspirantes.put("Walk", a7);
            aspirantes.put("Slime", a8);
            aspirantes.put("Dunk", a9);
            aspirantes.put("Hills", a10);
        } catch(IllegalArgumentException e){
            System.out.println("Error al registrar a un aspirante:" + e.getMessage());
        }
        
    }
    
    /**
     * Devuelve el iterador que se concentra en los valores de los elementos de la tabla Hash que ya contiene java.
     * Ignora las llaves, pues no las necesitamos.
     * @return el iterador de la tabla Hash aspirantes centrandose en los valores unicamente.
     */
    public Iterator getIterator(){
        return aspirantes.values().iterator();
    }
}