package monitorsystem;

public class UnidadeEuclidiana extends UnidadeMonitora {
    
    public UnidadeEuclidiana(String id, Equipamentos eqp, float x, float y) {
        this.setId(id);
        this.setConfiguracao(eqp);
        this.setX(x);
        this.setY(y);
    };
    
    public float getDistancia(float x, float y) {
        double a = Math.pow(this.getX() - x, 2);
        double b = Math.pow(this.getY() - y, 2);
        
        return (float)Math.sqrt(a + b);
    };
    
    public String toString() {
    	return "ID = " + this.getId() + " X = " + this.getX() + " Y = " + this.getY();
    };
}