/**
 * Clase hija de Ninja que le da comportamiento a un ninja aspirante.
 */
public class NinjaAspirante extends Ninja{

    /**
     * constructor de un ninja aspirante que usa el constructor de ninja y verifica que su nivel de habilidad este entre 1 y 3.
     * @param nombre nombre del ninja aspirante.
     * @param edad edad del ninja aspirante.
     * @param clan clan al que pertenece el ninja aspirante.
     * @param nivelDeHabilidad nivel de habilidad del ninja aspirante.
     */
    public NinjaAspirante(String nombre, int edad, Clan clan, int nivelDeHabilidad){
        
        super(nombre,edad,clan,nivelDeHabilidad);
        
        if(nivelDeHabilidad<1 || nivelDeHabilidad>3){
            throw new IllegalArgumentException("El nivel de habilidad de un aspirante debe estar entre 1 y 3.");
        }
        
    }
}