import java.util.ArrayList;
import java.util.List;

/**
 * Builder concreto que arma paso a paso el paquete de herramientas.
 * Va guardando las herramientas que se le piden agregar usando la
 * HerramientaFabrica (asi no se necesita escribir new para cada
 * herramienta), y cuando se le pide construir(), entrega el paquete
 * ya terminado con su peso total ya sumado
 */
public class PaqueteBuilderConcreto implements PaqueteBuilder {
    private List<Herramienta> herramientas;
    private HerramientaFabrica fabrica;

    /**
     * Crea el builder ya listo para empezar a agregar herramientas
     */
    public PaqueteBuilderConcreto(){
        this.fabrica = new HerramientaFabrica();
        this.herramientas = new ArrayList<Herramienta>();
    }

    /**
     * Le pide a la fabrica la herramienta solicitada, la cantidad de
     * veces que se indique, y la va agregando a la lista del paquete
     * que se esta armando
     * @param tipo nombre de la herramienta, el mismo que usa HerramientaFabrica
     * @param cantidad cuantas herramientas de ese tipo se van a agregar
     * @return el mismo builder, para poder seguir agregando mas herramientas
     */
    @Override
    public PaqueteBuilder agregarHerramienta(String tipo, int cantidad){
        for (int i = 0; i < cantidad; i++){
            Herramienta herramienta = fabrica.crear(tipo);
            herramientas.add(herramienta);
        }
        return this;
    }

    /**
     * Vacia la lista de herramientas para que el builder se pueda
     * volver a usar y armar un paquete distinto desde cero
     * @return el mismo builder, ya vacio
     */
    @Override
    public PaqueteBuilder reset(){
        herramientas = new ArrayList<Herramienta>();
        return this;
    }

    /**
     * Suma el peso de cada herramienta que se fue agregando y con
     * eso arma el paquete final. Este metodo no vacia la lista por su
     * cuenta, si se quiere armar otro paquete despues hay que llamar
     * a reset() primero
     * @return el paquete ya construido, con su lista de herramientas y su peso total
     */
    @Override
    public Paquete construir(){
        double pesoTotal = 0.0;
        for (Herramienta herramienta : herramientas){
            pesoTotal += herramienta.getPeso();
        }
        return new Paquete(herramientas, pesoTotal);
    }

}