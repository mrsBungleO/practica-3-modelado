/**
 * Enumeración de los rangos disponibles que un ninja voluntario puede tener.
 */
public enum Rango{
    /***Rango Genin. */
    GENIN("Genin", 1),

    /**Rango Chunin .*/
    CHUNIN("Chunin", 2),

    /**Rango Jonin. */
    JONIN("Jonin", 3);

    /**Nombre del rango.*/
    private final String NOMBRE;
    
    /**Numero maximo de aspirantes que puede tener cada rango .*/
    private final int MAXIMO_DE_ASPIRANTES;

    /**
     * Constructor de un rango
     * @param nombre el nombre del rango.
     * @param maximoDeAspirantes el número máximo de aspirantes que puede tener el rango.
     */
    Rango(String nombre, int maximoDeAspirantes){
        this.NOMBRE=nombre;
        this.MAXIMO_DE_ASPIRANTES= maximoDeAspirantes;
    }

    /**
     * Obtiene el nombre del rango.
     * @return el nombre del rango.
     */
    public String getNombre(){
        return NOMBRE;
    }

    /**
     * Obtiene el maximo de aspirantes que puede tener el rango.
     * @return el maximo de aspirantes que puede tener el rango.
     */
    public int getMaximoDeAspirantes(){
        return MAXIMO_DE_ASPIRANTES;
    }
}