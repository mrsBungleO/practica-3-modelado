import java.util.List;

/**
 * Paquete de herramientas ninja que se le entrega a un grupo.
 * Guarda la lista de herramientas que trae dentro y el peso total,
 * que ya viene calculado desde el Builder que lo construyo
 */
public class Paquete {
    private List<Herramienta> herramientas;
    private double pesoTotal;

    /**
     * @param herramientas lista de herramientas que trae el paquete
     * @param pesoTotal peso total del paquete en kilogramos
     */
    public Paquete(List<Herramienta> herramientas, double pesoTotal){
        this.herramientas = herramientas;
        this.pesoTotal = pesoTotal;
    }

    /**
     * @return lista de herramientas que trae el paquete
     */
    public List<Herramienta> getHerramientas(){
        return herramientas;
    }

    /**
     * @return peso total del paquete en kilogramos
     */
    public double getPesoTotal(){
        return pesoTotal;
    }

    /**
     * Junta el nombre de cada herramienta y el peso total en un solo
     * texto, para poder mostrarle al usuario que trae el paquete
     * @return resumen en texto del contenido del paquete
     */
    public String generarResumen(){
        String resumen = "Paquete con " + herramientas.size() + " herramienta(s): ";
        for (Herramienta herramienta : herramientas){
            resumen += herramienta.getNombre() + " ";
        }
        resumen += "- Peso total: " + pesoTotal + " kg";
        return resumen;
    }

}