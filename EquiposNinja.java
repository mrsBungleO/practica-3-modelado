import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que hace la repartición de equipos, les asigna un paquete de herramientas y un campo de entrenamiento.
 */
public class EquiposNinja{
    
    /**Los grupos de aspirantes y voluntarios junto con sus iteradores. */
    private Grupos grupos= new Grupos();

    /**Array list que almacena a los equipos formados. */
    private ArrayList<Equipo> equiposFormados= new ArrayList<>();

    /** Builder con el que se arman los paquetes */
    private PaqueteBuilder builder = new PaqueteBuilderConcreto();

    /** Director que conoce las recetas de los paquetes prefabricados */
    private DirectorPaquetes director = new DirectorPaquetes(builder);

    /**
     * Constructor de los equipos Ninja. No hay parametros, pues los grupos de ninjas ya han sido creados
     * y el array list de equipos se hará después.
     */
    public EquiposNinja(){
        grupos= new Grupos();
        equiposFormados= new ArrayList<>();
    }

    /**
     * Método que hace uso de los iteradores de cada grupo y forma los equipos haciendo uso del rango de los ninjas voluntarios que son lideres.
     * Imprime mensajes en terminal que simulan la repartición de equipos y anuncia cuando a un lider no se le asigna aspirantes o cuando a los 
     * aspirantes no se les asigna algun lider. 
     */
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
                Equipo nuevoEquipo= new Equipo(lider, aspirantesDelEquipo);
                equiposFormados.add(nuevoEquipo);
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

    /**
     * Asigna el paquete de herramientas a cada equipo formado
     * Se reparten por turnos segun la posicion del equipo: Basico, Avanzado, Tactico y Personalizado
     * y luego se repite el ciclo.
     */
    public void repartirPaqueteHerramientas(){
        System.out.println("Ahora pasamos a las entregas de herramientas ninjas. Cada equipo recibira un paquete\n");
        int numEquipo = 1;
        for(Equipo equipo: this.getEquiposFormados()){
            Paquete paquete;
            String tipo; 

            switch((numEquipo-1)%4){
                case 0:
                    paquete = director.construirPaqueteBasico();
                    tipo = "Basico";
                    break;
                case 1:
                    paquete = director.construirPaqueteAvanzado();
                    tipo = "Avanzado";
                    break;
                case 2:
                    paquete = director.construirPaqueteTactico();
                    tipo = "Tactico";
                    break;
                default:
                    paquete = construirPaquetePersonalizado();
                    tipo = "Personalizado";
                    break;
            }
            equipo.setPaqueteHerramientas(paquete);

            System.out.println("Equipo " + numEquipo + " con el lider " + equipo.getLider().getNombre() + ": recibe el Paquete " + tipo + ".");
            System.out.println(paquete.generarResumen());
            System.out.println("");
            numEquipo++;
        }
    }

    /**
    * Arma un paquete personalizado usando el builder directamente, sin pasar
    * por el director:3 Kunai, 2 Papeles Bomba, 1 Bomba de Humo y 1 Botiquin
    * @return el paquete personalizado ya construido
    */
   public Paquete construirPaquetePersonalizado(){
    builder.reset();
    builder.agregarHerramienta("kunai", 3)
               .agregarHerramienta("papelbomba", 2)
               .agregarHerramienta("bombahumo", 1)
               .agregarHerramienta("botiquin", 1);
        return builder.construir();
    }


    /**
     * Método que simula la repartición de un campo de entrenamiento a un equipo e imprime los detalles.
     */
    public void repartirCampo(){
        System.out.println("Continuamos con la etapa de asignación de campos de entrenamiento. Cada equipo tendrá derecho a un campo donde entrenará\ny este se les asignará " + 
                            "evaluando la suma de las habilidades de los integrantes. Veamos:\n");
        System.out.println("* Si la suma del nivel de habilidad del equipo es menor o igual a 7, entonces entrenará en el Valle Del Dragón.");
        System.out.println("* Si la suma del nivel de habilidad del equipo va de 8 a 11, entonces entrenará en el Bosque Sombrío.");
        System.out.println("* Si la suma del nivel de habilidad del equipo es mayor o igual a 12, entonces entrenará en la Montaña Espiritual.");

        System.out.println("\n¡QUE COMIENCE LA ASIGNACIÓN!");

        int numEquipo=1;

        for(Equipo equipo: this.getEquiposFormados()){
            int sumaTotal= equipo.getSumaHabilidad();
            CampoFabrica fabrica= CampoFabrica.elegirFabrica(sumaTotal);
            CampoEntrenamiento campo= fabrica.asignarCampo();
            equipo.setCampoDeEntrenamiento(campo);

            System.out.println("Equipo " + numEquipo + " con el lider " + equipo.getLider().getNombre() + ":");
            System.out.println("Con una suma de nivel de habilidad de " + equipo.getSumaHabilidad() + " se les ha asignado " + equipo.getCampoDeEntrenamiento().getNombre() + " para poder entrenar.");
            System.out.println("");
            numEquipo++;
        }

    }

    /**
     * Devuelve el array list que contiene a los equipos formados.
     * @return la listq ue contiene a los equipos formados.
     */
    public ArrayList<Equipo> getEquiposFormados(){
        return equiposFormados;
    }

    /**
     * Método que imprime cada equipo en la lista de equipos formados junto con su información.
     */
    public void imprimirEquipos(){

        ArrayList<Equipo> equiposFormados= this.getEquiposFormados();

        for(int i=0; i<equiposFormados.size(); i++){
            System.out.println("= EQUIPO " + (i+1) + " =");
            equiposFormados.get(i).imprimirEquipo();
        }

    }

    

    
}