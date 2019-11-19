public class Gene{
    private int valor;
    
    public Gene(int valor){
        this.setValor(valor); 
    };
    
    public Gene(Gene gene){
        this(gene.getValor());
    }; 
    
    public Gene(){
        this(1);
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
    
    public Gene clonar(){
        return new Gene(this);
    };
    
    public String toString(){
        return "Valor: " + this.getValor();
        //return Integer.toString(this.getValor());
    }
    
}