public class Cromossomo{
    private Gene[] genes;
    
    public Cromossomo(int qtdGenes){
        this.genes = new Gene[qtdGenes];
    };
    
    public void setGene(int alelo, int valor){
       genes[alelo] = new Gene(valor);
    };
    
    public Gene buscarGene(int alelo){
        return genes[alelo];
    };
    
    public Cromossomo clonar(){
        Cromossomo novo = new Cromossomo(this.genes.length);
      
        int i;
        for(i = 0; i < this.genes.length; i++)
            novo[i] = new Gene(this.genes[i].getValor);
            
        
    };
   
}