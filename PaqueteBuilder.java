/**
 * Interfaz del Builder de paquetes de herramientas ninja.
 * Aqui se definen los pasos que cualquier builder de paquetes debe
 * poder hacer: agregar herramientas poco a poco, reiniciarse para
 * empezar un paquete nuevo, y al final entregar el paquete terminado
 */
public interface PaqueteBuilder {

    /**
     * Agrega una cierta cantidad de una herramienta al paquete que se
     * esta armando. Se puede llamar varias veces para ir agregando
     * distintas herramientas antes de construir el paquete final
     * @param tipo nombre de la herramienta, el mismo que usa HerramientaFabrica
     * @param cantidad cuantas herramientas de ese tipo se van a agregar
     * @return el mismo builder, para poder encadenar varias llamadas
     */
    public PaqueteBuilder agregarHerramienta(String tipo, int cantidad);

    /**
     * Limpia todo lo que se habia agregado hasta el momento, para que
     * el builder se pueda reutilizar y armar un paquete nuevo desde cero
     * @return el mismo builder, ya vacio y listo para empezar de nuevo
     */
    public PaqueteBuilder reset();

    /**
     * Toma todas las herramientas que se fueron agregando y arma con
     * ellas el paquete final, ya con su peso total calculado
     * @return el paquete ya construido
     */
    public Paquete construir();

}