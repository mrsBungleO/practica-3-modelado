import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EquiposNinja{
    
    private Grupos grupos= new Grupos();
    private HashMap<NinjaVoluntario, ArrayList<NinjaAspirante>> equiposFormados= new HashMap<>();

    public EquiposNinja(){
        grupos= new Grupos();
        equiposFormados= new HashMap<>();
    }

    public void formarEquipos(){

        Iterator aspirantes= grupos.getIteradorAspirantes();
        Iterator voluntarios= grupos.getIteradorVoluntarios();

        System.out.println("\n¡BIENVENIDOS A LA ETAPA DE REPARTICIÓN DE EQUIPOS!\n\nA cada uno de nuestros ninjas voluntarios se les asignará una cantidad de aspirantes proporcional a su rango.");
        System.out.println("Nuestros ninjas voluntarios serán los líderes de cada equipo y ayudarán a nuestros aspirantes a tener un desempeño excepcional.\n");
        System.out.println("Veamos la asignación: \n");

        while(voluntarios.hasNext()){

            NinjaVoluntario lider= (NinjaVoluntario)voluntarios.next();
            int limite= lider.getRango().getMaximoDeAspirantes();

            ArrayList<NinjaAspirante> aspirantesDelEquipo= new ArrayList<>();

            for(int i=0; i<limite; i++){
                if(aspirantes.hasNext()){
                    NinjaAspirante elemento= (NinjaAspirante)aspirantes.next();
                    aspirantesDelEquipo.add(elemento);
                    System.out.println("El aspirante " + elemento.getNombre() + " ha sido asignado al equipo de " + lider.getNombre());
                    System.out.println("============================================================================================");
                }
            }

            if(!aspirantesDelEquipo.isEmpty()){
                equiposFormados.put(lider,aspirantesDelEquipo);
            } else{
                System.out.println("\nYa no quedan más aspirantes. " + lider.getNombre() + " no esta al frente de algún equipo.");
            }
        }


        if(aspirantes.hasNext()){
            System.out.println("\n¡Lo sentimos! Se han agotado los voluntarios.");
            System.out.println("\nLos siguientes aspirantes no fueron seleccionados: \n");

            while(aspirantes.hasNext()){
                NinjaAspirante rechazado= (NinjaAspirante)aspirantes.next();
                System.out.println("--> " + rechazado.getNombre());
            }

            System.out.println("");

        } else {
            System.out.println("\n¡La repartición de equipos ha sido completada!\n");
        }
        
    }

    public HashMap<NinjaVoluntario, ArrayList<NinjaAspirante>> getEquiposFormados(){
        return equiposFormados;
    }

    
}