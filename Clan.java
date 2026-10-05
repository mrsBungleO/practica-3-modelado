public enum Clan{
   
    FUCHIHA("Fuchiha"),
    OSOMAKI("Osomaki"),
    NACA("Naca"),
    MORTALIKA("Mortalika"),
    AKIPICHI("Akipichi");

    private final String NOMBRE;

    Clan(String nombre){
        this.NOMBRE=nombre;
    }

    public String getNombre(){
        return NOMBRE;
    }
}