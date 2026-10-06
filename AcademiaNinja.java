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

        System.out.println("\n*_*_*_*_* ACADEMIA NINJA DE LA ALDEA DE LAS CIENCIAS *_*_*_*_*_\n");
        System.out.println("------ Ceremonia de asignación ------");
        equiposNinja.formarEquipos();
        equiposNinja.repartirPaqueteHerramientas();
        equiposNinja.repartirCampo();
        System.out.println("== RESUMEN DE LA CEREMONIA ==\n");
        equiposNinja.imprimirEquipos();
        
    }
}