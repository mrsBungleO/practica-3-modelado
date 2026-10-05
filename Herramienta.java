/**
 * Herramienta ninja que puede ir dentro de un paquete
 * Todas tienen un nombre u un peso que sirve para calcular 
 * el total del paquete
 */
public abstract class Herramienta {
    protected String nombre;
    protected double peso;

    /**
     * @param nombre nombre de la herramienta
     * @param peso peso en kilogramos
     */
    public Herramienta(String nombre, double peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * @return nombre de la herramienta
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @return peso en kilogramos
     */
    public double getPeso(){
        return peso;
    }
    
}
