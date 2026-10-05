import java.util.ArrayList;
import java.util.Iterator;

public class GrupoVoluntarios{

    private ArrayList<NinjaVoluntario> voluntarios= new ArrayList<>();

    public GrupoVoluntarios(){
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
    }

    public Iterator getIterator(){
        return voluntarios.iterator();
    }
}