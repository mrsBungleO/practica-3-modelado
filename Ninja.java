/**
 * Clase abstracta que define los componentes que todo ninja debe tener.
 * Guarda su nombre, su edad, su clan y su nivel de habilidad.
 */
public abstract class Ninja{

    /**Nombre del ninja .*/
    private String nombre;

    /**Edad del ninja. */
    private int edad;

    /**Clan al que pertenece el ninja. */
    private Clan clan;

    /**Nivel de habilidad del ninja. */
    private int nivelDeHabilidad;

    /**
     * Constructor de un ninja.
     * @param nombre nombre del ninja.
     * @param edad edad del ninja.
     * @param clan clan al que pertenece el ninja.
     * @param nivelDeHabilidad nivel de habilidad del ninja.
     */
    public Ninja(String nombre,int edad, Clan clan, int nivelDeHabilidad){
        this.nombre= nombre;
        this.edad= edad;
        this.clan= clan;
        this.nivelDeHabilidad= nivelDeHabilidad;
    }

    /**
     * Devuelve el nombre del ninja.
     * @return el nombre del ninja.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Devuelve la edad del ninja.
     * @return la edad del ninja.
     */
    public int getEdad(){
        return edad;
    }

    /**
     * Devuelve el clan del ninja.
     * @return el clan al que pertenece el ninja.
     */
    public Clan getClan(){
        return clan;
    }

    /**Devuelve el nivel de habilidad del ninja.
     * @return el nivel de habilidad del ninja.
     */
    public int getNivelDeHabilidad(){
        return nivelDeHabilidad;
    }

}