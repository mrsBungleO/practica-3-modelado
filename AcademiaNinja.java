import java.util.ArrayList;

/**
 * Clase que simula como la academia ninja realiza la ceremonia de repartición de equipos, paquetes de herramientas y campo de entrenamiento.
 */
public class AcademiaNinja{

    /**
     * Método que se encarga de toda la simulación de la academia usando métodos de otras clases relacionadas.
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args){

        EquiposNinja equiposNinja = new EquiposNinja();

        equiposNinja.formarEquipos();
        equiposNinja.repartirCampo();
        equiposNinja.imprimirEquipos();
        
    }
}