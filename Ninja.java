public abstract class Ninja{

    private String nombre;
    private int edad;
    private Clan clan;
    private int nivelDeHabilidad;

    public Ninja(String nombre,int edad, Clan clan, int nivelDeHabilidad){
        this.nombre= nombre;
        this.edad= edad;
        this.clan= clan;
        this.nivelDeHabilidad= nivelDeHabilidad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public Clan getClan(){
        return clan;
    }

    public int getNivelDeHabilidad(){
        return nivelDeHabilidad;
    }

}