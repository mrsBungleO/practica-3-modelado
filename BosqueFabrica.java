/**
 * Clase concreta que crea el campo Bosque Sombrio
 */
public class BosqueFabrica extends CampoFabrica {
    /**
     * Crea al BosqueSOmbrio
     * @return una nueva instancia de BosqueSombrio
     */
    @Override 
    protected CampoEntrenamiento crearCampo(){
        return new BosqueSombrio();
    }
    
}
