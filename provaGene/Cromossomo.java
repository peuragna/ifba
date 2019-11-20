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
            Cromossomo novo = new Cromossomo(outro.genes.length);
            Cromossomo novo2 = new Cromossomo(this.genes.length);
            
            if(this.genes.length <= outro.genes.length){
                for(int i = 0; i < this.genes.length - ponto; i++)
                    novo.setGene(i, this.getGene(i).getValor());
                    
                for(int i = ponto; i < novo.genes.length; i++)
                   novo.setGene(i, outro.getGene(i).getValor());
                   
                for(int i = 0; i < this.genes.length - ponto; i++)
                    novo2.setGene(i, outro.getGene(i).getValor());
                    
                for(int i = ponto; i < novo2.genes.length; i++)
                    novo2.setGene(i, this.getGene(i).getValor());
                    
                this.genes = novo.genes;    
                outro.genes = novo2.genes;
            }else{
                for(int i = 0; i < outro.genes.length - ponto; i++)
                    novo.setGene(i, this.getGene(i).getValor());
                    
                for(int i = ponto; i < novo.genes.length; i++)
                    novo.setGene(i, outro.getGene(i).getValor());
                
                for(int i = 0; i < this.genes.length - ponto; i++)
                    novo2.setGene(i, outro.getGene(i).getValor());
                    
                for(int i = ponto; i < novo2.genes.length; i++)
                    novo2.setGene(i, this.getGene(i).getValor());
                
                this.genes = novo.genes;    
                outro.genes = novo2.genes;
            }
            
    };
}