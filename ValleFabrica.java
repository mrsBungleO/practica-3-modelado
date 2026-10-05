/**
 * Clase concreta que crea el campo Valle
 */
public class ValleFabrica extends CampoFabrica{

    /**
     * @return una nueva instancia de Valle del Dragon
     */
    @Override 
    protected CampoEntrenamiento crearCampo(){
        return new ValleDelDragon();
    }
    
}