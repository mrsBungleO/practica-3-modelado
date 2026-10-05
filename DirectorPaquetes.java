/**
 * Director que conoce las "recetas" de los paquetes prefabricados
 * (Basico, Avanzado y Tactico) y le va diciendo al builder que
 * herramientas agregar para armar cada uno. Asi quien use esta clase
 * no necesita saber de que esta hecho cada paquete, solo pide el
 * paquete que quiere y el director se encarga de armarlo con el
 * builder que se le dio
 */
public class DirectorPaquetes {
    private PaqueteBuilder builder;

    /**
     * @param builder builder que se usara para ir agregando las herramientas
     */
    public DirectorPaquetes(PaqueteBuilder builder){
        this.builder = builder;
    }

    /**
     * Arma el Paquete Basico: 1 Kunai, 1 Shuriken, 1 Botiquin
     * @return el paquete basico ya construido
     */
    public Paquete construirPaqueteBasico(){
        builder.reset();
        builder.agregarHerramienta("kunai", 1);
        builder.agregarHerramienta("shuriken", 1);
        builder.agregarHerramienta("botiquin", 1);
        return builder.construir();
    }

    /**
     * Arma el Paquete Avanzado: 2 Shuriken, 3 Papeles Bomba,
     * 2 Bombas de Humo, 2 Botiquines
     * @return el paquete avanzado ya construido
     */
    public Paquete construirPaqueteAvanzado(){
        builder.reset();
        builder.agregarHerramienta("shuriken", 2);
        builder.agregarHerramienta("papelbomba", 3);
        builder.agregarHerramienta("bombahumo", 2);
        builder.agregarHerramienta("botiquin", 2);
        return builder.construir();
    }

    /**
     * Arma el Paquete Tactico: 3 Kunai, 2 Shuriken, 4 Papeles Bomba,
     * 2 Bombas de Humo
     * @return el paquete tactico ya construido
     */
    public Paquete construirPaqueteTactico(){
        builder.reset();
        builder.agregarHerramienta("kunai", 3);
        builder.agregarHerramienta("shuriken", 2);
        builder.agregarHerramienta("papelbomba", 4);
        builder.agregarHerramienta("bombahumo", 2);
        return builder.construir();
    }

}