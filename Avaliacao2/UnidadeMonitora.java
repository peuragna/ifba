public abstract class UnidadeMonitora{
    private String id;
    private Equipamentos configuracao;
    private float x, y;
    
    public abstract float getDistancia(float x, float y);
    
    public void moveTo(float x, float y) {
        this.setX(x);
        this.setY(y);
    };
    
    public String getId() {
        return id;
    };
    
    public void setId(String id) {
        this.id = id;
    };
    
    public float getX() {
        return x;
    };
    
    public void setX(float x) {
        this.x = x;
    };
    
    public float getY() {
        return y;
    };
    
    public void setY(float y) {
        this.y = y;
    };
    
    public Equipamentos getConfiguracao() {
        return this.configuracao;
    };
    
    public void setConfiguracao(Equipamentos eqp) {
        this.configuracao = eqp;
    };
}

