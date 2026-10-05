/**
 * Fabrica que se encarga de crear las herramientas ninja
 * Quien necesite una herramienta se la pide por su nombre, 
 * sin tener que usar new con cada clase
 */
public class HerramientaFabrica {

    /**
     * Crea una herramienta a partir de su nomnbre
     * @param tipo "kunai", "shuriken", "papelbomba", "bombahumo" o "botiquin"
     * @return la herramienta solicitada
     * @throws IllegalArgumentException si el tipo no existe
     */
    public Herramienta crear(String tipo){
        switch (tipo.toLowerCase()) {
            case "kunai": return new Kunai();
            case "shuriken": return new Shuriken();
            case "papelbomba": return new PapelBomba();
            case "bombahumo": return new BombadeHumo();
            case "botiquin": return new Botiquin();
            default:
                throw new IllegalArgumentException("Herramienta desconocida: " + tipo);
        }
    }
    
}
