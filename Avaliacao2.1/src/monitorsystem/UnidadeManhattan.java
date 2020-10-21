package monitorsystem;

public class UnidadeManhattan extends UnidadeMonitora {
    
    public UnidadeManhattan(String id, Equipamentos eqp, float x, float y) {
        this.setId(id);
        this.setConfiguracao(eqp);
        this.setX(x);
        this.setY(y);
    };
    
    public float getDistancia(float x, float y) {
        float a = this.getX() - x;
        float b = this.getY() - y;
        
        return Math.abs(a) + Math.abs(b);
    };
}