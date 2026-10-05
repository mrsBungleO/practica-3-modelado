/**
 * Enumeración de los clanes disponibles a los que cada ninja puede permanecer.
 */
public enum Clan{
  
   /**Clan Fuchiha. */
    FUCHIHA("Fuchiha"),

    /**Clan Osomaki. */
    OSOMAKI("Osomaki"),

    /**Clan Naca. */
    NACA("Naca"),

    /**Clan Mortalika. */
    MORTALIKA("Mortalika"),

    /**Clan Akipichi. */
    AKIPICHI("Akipichi");

    /**Nombre del clan. */
    private final String NOMBRE;
    
    /**
     * Constructor de un clan usando su nombre.
     * @param nombre el nombre del clan.
     */
    Clan(String nombre){
        this.NOMBRE=nombre;
    }

    /**
     * obtiene el nombre del clan.
     * @return el nombre del clan.
     */
    public String getNombre(){
        return NOMBRE;
    }
}