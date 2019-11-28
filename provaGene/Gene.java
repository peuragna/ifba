public class Gene{
    private int valor;
    
    public Gene(int valor){
        this.setValor(valor); 
    };
    
    public Gene(Gene gene){
        this(gene.getValor());
    }; 
    
    public void setValor(int valor){
        this.valor = valor;
    };
    
    public int getValor(){
        return this.valor;
    };
    
    public boolean equals(Gene outro){
        return this.getValor() == outro.getValor();
    };
    
    public String toString(){
        return "(" + this.getValor() + ")";
    };
   
    public Gene clonar(){
        return new Gene(this);
    };   
}
