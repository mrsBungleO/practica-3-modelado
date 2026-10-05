public enum Rango{

    GENIN("Genin", 1),
    CHUNIN("Chunin", 2),
    JONIN("Jonin", 3);

    private final String NOMBRE;
    private final int MAXIMO_DE_ASPIRANTES;

    Rango(String nombre, int maximoDeAspirantes){
        this.NOMBRE=nombre;
        this.MAXIMO_DE_ASPIRANTES= maximoDeAspirantes;
    }

    public String getNombre(){
        return NOMBRE;
    }

    public int getMaximoDeAspirantes(){
        return MAXIMO_DE_ASPIRANTES;
    }
}