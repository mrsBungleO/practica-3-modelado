public class NinjaVoluntario extends Ninja{

    private Rango rango;

    public NinjaVoluntario(String nombre, int edad, Clan clan, int nivelDeHabilidad, Rango rango){
        super(nombre,edad,clan,nivelDeHabilidad);
        
        this.rango= rango;

        if(nivelDeHabilidad<4 || nivelDeHabilidad>6){
            throw new IllegalArgumentException("El nivel de habilidad de un aspirante debe estar entre 4 y 6.");
        }
    }

    public Rango getRango(){
        return rango;
    }
}