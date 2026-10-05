import java.util.Hashtable;
import java.util.Iterator;

public class GrupoAspirantes{

    private Hashtable<String,NinjaAspirante> aspirantes= new Hashtable<>();

    public GrupoAspirantes(){
        
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
    }

    public Iterator getIterator(){
        return aspirantes.values().iterator();
    }
}