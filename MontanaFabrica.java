/**
 * Clase concreta que crea el campo MOntana
 */
public class MontanaFabrica extends CampoFabrica{

    /**
     * @return una nueva instancia de Montana Espiritual
     */
    @Override 
    protected CampoEntrenamiento crearCampo(){
        return new MontanaEspiritual();
    }
    
}
