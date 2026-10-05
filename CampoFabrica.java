/**
 * Clase abstracta que se encarga de crear los campos de entrenamiento.
 * Cada fábrica hija decide qué campo crear en crearCampo(), y el resto
 * del programa solo usa asignarCampo() sin saber de qué campo se trata.
 */
public abstract class CampoFabrica {
    
    /**
     * Metodo de fabrica, las subclases devuelven el campo que toca
     * @return el campo de entrenamiento creado
     */
    protected abstract CampoEntrenamiento crearCampo();

    /**
     * Pide el campo a la subclase y lo entrega
     * @return campo de entrenamiento asignado
     */
    public  CampoEntrenamiento asignarCampo(){
        return crearCampo();
    }

    /**
     * Elige la fabrica segun la suma de habilidad del grupo
     * @param sumaHabilidad suma de los niveles de habilidad 
     * @return la fabrica que correspone segun el puntaje
     */
    public static  CampoFabrica elegirFabrica(int sumaHabilidad){
        if (sumaHabilidad <= 7){
            return new ValleFabrica();
        } else if (sumaHabilidad <= 11){
            return new BosqueFabrica();
        }
        return new MontanaFabrica();
    }
    
}