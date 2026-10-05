public class NinjaAspirante extends Ninja{

    public NinjaAspirante(String nombre, int edad, Clan clan, int nivelDeHabilidad){
        
        super(nombre,edad,clan,nivelDeHabilidad);
        
        if(nivelDeHabilidad<1 || nivelDeHabilidad>3){
            throw new IllegalArgumentException("El nivel de habilidad de un aspirante debe estar entre 1 y 3.");
        }
        
    }
}