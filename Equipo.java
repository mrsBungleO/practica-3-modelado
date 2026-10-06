import java.util.ArrayList;

/**
 * Clase que le da estructura a los elementos que debe tener un equipo, para después poder manipularlo.
 */
public class Equipo{

    /**El ninja voluntario que será lider del equipo. */
    private NinjaVoluntario lider;

    /**La lista de ninjas aspirantes que serán delegados al lider. */
    private ArrayList<NinjaAspirante> integrantes;

    /**Paquete de herramientas ninja que recibe el equipo */
    private Paquete paqueteHerramientas;

    /**Campo de entrenamiento donde se desempeñará el equipo. */
    private CampoEntrenamiento campoDeEntrenamiento;

    /**
     * Constructor del equipo que nos servirá en la asignación de este. Por esta razón no contiene campo de entrenamiento ni paquete de herramientas,
     * porque eso será en una etapa posterior.
     * @param lider el ninja voluntario que liderará al equipo.
     * @param integrantes los aspirantes delegados al lider.
     */
    public Equipo(NinjaVoluntario lider, ArrayList<NinjaAspirante> integrantes){
        this.lider=lider;
        this.integrantes=integrantes;
        this.campoDeEntrenamiento=null;
    }

    /**
     * Devuelve al lider del equipo.
     * @return al lider del equipo.
     */
    public NinjaVoluntario getLider(){
        return lider;
    }

    /**
     * Devuelve la lista de aspirantes del equipo.
     * @return la lista de integrantes.
     */
    public ArrayList<NinjaAspirante> getIntegrantes(){
        return integrantes;
    }

    /**
     * Devuelve el paquete de herramientas asignado al equipo
     * @return el paquete del equipo o si todavia no se la asigna uno
     */
    public  Paquete getPaqueteHerramientas(){
        return paqueteHerramientas;
    }

    /**
     * Devuelve el campo de entrenamiento asignado al equipo.
     * @return el campo de entrenamiento del equipo.
     */
    public CampoEntrenamiento getCampoDeEntrenamiento(){
        return campoDeEntrenamiento;
    }

    /**
     * Asigna un paquete de heramientas al equipo
     * @param paqueteHerramientas el paquete asignado al equipo
     */
    public void setPaqueteHerramientas(Paquete paqueteHerramientas){
        this.paqueteHerramientas = paqueteHerramientas;
    }

    /**
     * Asigna un campo de entrenamiento al equipo. Nos sirve para hacer la simulación de esta etapa, ya que en el constructor no le asignamos
     * campo de entrenamiento.
     * @param campoDeEntrenamiento el campo de entrenamiento asignado al equipo.
     */
    public void setCampoDeEntrenamiento(CampoEntrenamiento campoDeEntrenamiento){
        this.campoDeEntrenamiento=campoDeEntrenamiento;
    }

    /**
     * Imprime a los elementos del equipo, su paquete de herramientas y su campo de entrenamiento.
     */
    public void imprimirEquipo(){

        System.out.println("\nEquipo liderado por " + this.getLider().getNombre() + ".");
        System.out.println("Integrantes: ");
        for(NinjaAspirante integrante: this.getIntegrantes()){
            System.out.println("-" + integrante.getNombre());
        }
        System.out.println(this.getPaqueteHerramientas().generarResumen());
        System.out.println("Campo de entrenamiento: " + this.getCampoDeEntrenamiento().getNombre() + " - " + this.getCampoDeEntrenamiento().getDescripcion());
        System.out.println("");

    }

    /**
     * Suma los niveles de habilidad de cada elemento del equipo para que se les asigne un campo de entrenamiento.
     * @return la suma de los niveles de habilidad.
     */
    public int getSumaHabilidad(){
        int suma= this.getLider().getNivelDeHabilidad();
        for(NinjaAspirante aspirante: this.getIntegrantes()){
            suma+= aspirante.getNivelDeHabilidad();
        }
        return suma;
    }
}