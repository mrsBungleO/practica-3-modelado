/**
 * Clase hija de ninja que da comportamiento a un ninja voluntario haciendo uso de un atributo rango.
 */
public class NinjaVoluntario extends Ninja{

    /** Rango del ninja voluntario */
    private Rango rango;

    /**
     * Constructor de un ninja voluntario que hace uso del constructor de ninja y añade el parametro rango. Además, evalua si el nivel de habilidad esta entre 4 y 6.
     * @param nombre nombre del ninja voluntario.
     * @param edad edad del ninja voluntario.
     * @param clan clan al que pertenece el ninja voluntario.
     * @param nivelDeHabilidad nivel de habilidad del ninja voluntario.
     * @param rango rando del ninja voluntario.
     */
    public NinjaVoluntario(String nombre, int edad, Clan clan, int nivelDeHabilidad, Rango rango){
        super(nombre,edad,clan,nivelDeHabilidad);
        
        this.rango= rango;

        if(nivelDeHabilidad<4 || nivelDeHabilidad>6){
            throw new IllegalArgumentException("El nivel de habilidad de un aspirante debe estar entre 4 y 6.");
        }
    }

    /**
     * Obtiene el rango del ninja.
     * @return el rango del ninja voluntario.
     */
    public Rango getRango(){
        return rango;
    }
}