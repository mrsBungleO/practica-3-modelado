import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
     * Asigna el paquete de herramientas a cada equipo formado.
     * Para cada equipo se muestra un menú y la persona que lleva la ceremonia
     * decide, desde la terminal, si el equipo recibe el Paquete Básico, Avanzado,
     * Táctico o uno Personalizado armado al momento.
     */
    public void repartirPaqueteHerramientas(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Ahora pasamos a las entregas de herramientas ninjas. Para cada equipo elige el paquete que le toca.\n");

        int numEquipo = 1;
        for(Equipo equipo: this.getEquiposFormados()){
            System.out.println("Equipo " + numEquipo + " con el lider " + equipo.getLider().getNombre() + ":");
            System.out.println("1) Paquete Basico");
            System.out.println("2) Paquete Avanzado");
            System.out.println("3) Paquete Tactico");
            System.out.println("4) Paquete Personalizado");

            int opcion = leerOpcionPaquete(lector);

            Paquete paquete;
            String tipo;

            switch(opcion){
                case 1:
                    paquete = director.construirPaqueteBasico();
                    tipo = "Basico";
                    break;
                case 2:
                    paquete = director.construirPaqueteAvanzado();
                    tipo = "Avanzado";
                    break;
                case 3:
                    paquete = director.construirPaqueteTactico();
                    tipo = "Tactico";
                    break;
                default:
                    paquete = construirPaquetePersonalizado(lector);
                    tipo = "Personalizado";
                    break;
            }
            equipo.setPaqueteHerramientas(paquete);

            System.out.println("\nEquipo " + numEquipo + " con el lider " + equipo.getLider().getNombre() + ": recibe el Paquete " + tipo + ".");
            System.out.println(paquete.generarResumen());
            System.out.println("");
            numEquipo++;
        }
    }

    /**
     * Le pregunta al usuario, desde la terminal, que opcion de paquete quiere para el equipo actual.
     * Si escribe algo que no sea un numero del 1 al 4, se lo vuelve a preguntar hasta que la respuesta sea valida.
     * @param lector scanner ya abierto con el que se lee lo que escribe el usuario
     * @return el numero de la opcion elegida, entre 1 y 4
     */
    private int leerOpcionPaquete(Scanner lector){
        int opcion = -1;
        while(opcion < 1 || opcion > 4){
            System.out.print("Elige una opcion (1-4): ");
            if(lector.hasNextInt()){
                opcion = lector.nextInt();
                if(opcion < 1 || opcion > 4){
                    System.out.println("Esa opcion no existe, intenta de nuevo.");
                }
            } else {
                System.out.println("Eso no es un numero, intenta de nuevo.");
                lector.next();
            }
        }
        return opcion;
    }

    /**
     * Arma un paquete personalizado preguntandole al usuario, herramienta por herramienta,
     * cuantas quiere agregar al paquete. Se usa el builder directamente, sin pasar por el director,
     * ya que aqui no se sigue ninguna receta fija.
     * @param lector scanner ya abierto con el que se lee lo que escribe el usuario
     * @return el paquete personalizado ya construido
     */
    public Paquete construirPaquetePersonalizado(Scanner lector){
        builder.reset();
        String[] tiposDisponibles = {"kunai", "shuriken", "papelbomba", "bombahumo", "botiquin"};
        String[] nombresBonitos = {"Kunai", "Shuriken", "Papel Bomba", "Bomba de Humo", "Botiquin"};

        System.out.println("\nVamos a armar el paquete personalizado. Dinos cuantas herramientas de cada tipo quieres agregar:");

        for(int i = 0; i < tiposDisponibles.length; i++){
            int cantidad = -1;
            while(cantidad < 0){
                System.out.print(nombresBonitos[i] + ": ");
                if(lector.hasNextInt()){
                    cantidad = lector.nextInt();
                    if(cantidad < 0){
                        System.out.println("La cantidad no puede ser negativa, intenta de nuevo.");
                    }
                } else {
                    System.out.println("Eso no es un numero, intenta de nuevo.");
                    lector.next();
                }
            }
            if(cantidad > 0){
                builder.agregarHerramienta(tiposDisponibles[i], cantidad);
            }
        }

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