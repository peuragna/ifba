public class Cromossomo{
    private Gene[] genes;
    
    public Cromossomo(int qtdGenes){
        this.genes = new Gene[qtdGenes];
    };
    
    public void setGene(int alelo, int valor){
       this.genes[alelo] = new Gene(valor);
    };
    
    public Gene getGene(int alelo){
        return this.genes[alelo];
    };
    
    public Cromossomo clonar(){
        Cromossomo novo = new Cromossomo(this.genes.length);
        int i;
        
        for(i = 0; i < this.genes.length; i++)
            novo.setGene(i, this.genes[i].getValor());
            
        return novo;
    };
    
    public float calcularSimilaridade(Cromossomo outro){
        float count = 0;
        
        for(int i = 0; i < this.genes.length; i++)
            if((this.getGene(i).getValor() == 0 && outro.getGene(i).getValor() != 0) || 
                (this.getGene(i).getValor() != 0 && outro.getGene(i).getValor() == 0));
                count -= 2;
                
        for(int i = 0; i < this.genes.length; i++){
            if(this.getGene(i).getValor() != 0)
                if(this.getGene(i).equals(outro.getGene(i))){
                    count += 1;
                }else count -= 1;    
        }
        return count;
    }; 
    
    public void cruzar(Cromossomo outro, int ponto){
        Cromossomo aux = new Cromossomo(this.genes.length);
        
        aux.genes = this.cruzamento(outro, ponto).genes;
        outro.genes = outro.cruzamento(this, ponto).genes;
        this.genes = aux.genes;
    };
    
    public Cromossomo cruzamento(Cromossomo outro, int ponto){
        Cromossomo novo = new Cromossomo(outro.genes.length);
        
        for(int i = 0; i < ponto; i++)
            novo.setGene(i, this.getGene(i).getValor());
            
        for(int i = ponto; i < novo.genes.length; i++)
            novo.setGene(i, outro.getGene(i).getValor());
            
        return novo;   
    };
}   

 