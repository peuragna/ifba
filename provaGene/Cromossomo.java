public class Cromossomo{
    private Gene[] genes;
    
    public Cromossomo(int qtdGenes){
        this.genes = new Gene[qtdGenes];
    };
    
    public void setGene(int alelo, Gene gene){
       this.genes[alelo] = gene;
    };
    
    public Gene getGene(int alelo){
        return this.genes[alelo];
    };
    
    public Cromossomo clonar(){
        Cromossomo novo = new Cromossomo(this.genes.length);
        
        for(int i = 0; i < this.genes.length; i++)
            novo.setGene(i, (this.getGene(i) != null) ?
                             this.getGene(i).clonar() : 
                             null);
            
        return novo;
    };
    
    public double getSimilaridade(Cromossomo outro){
        double count = 0;
        int max = this.genes.length > outro.genes.length ? this.genes.length : outro.genes.length;
        
        for(int i = 0; i < max; i++){
            Gene meuGene = (i < this.genes.length) ? this.getGene(i) : null;
            Gene outroGene = (i < outro.genes.length) ? outro.getGene(i) : null;
            
            if(meuGene == null || outroGene == null){
                if(meuGene != null || outroGene != null)
                    count -= 2;
            }else if(meuGene.equals(outroGene))
                count += 1;
             else 
                count -= 1;   
        }
        return count / this.genes.length;
    }; 
    
    public void cruzar(Cromossomo outro, int ponto){
        Cromossomo aux = new Cromossomo(this.genes.length);
        
        aux.genes = this.cruzamento(outro, ponto).genes;
        outro.genes = outro.cruzamento(this, ponto).genes;
        this.genes = aux.genes;
    };
    
    //Aplicar mesmo tratamento NULL!!
    
    public Cromossomo cruzamento(Cromossomo outro, int ponto){
        Cromossomo novo = new Cromossomo(outro.genes.length);
        
        for(int i = 0; i < ponto; i++)
            novo.setGene(i, this.getGene(i));
            
        for(int i = ponto; i < novo.genes.length; i++)
            novo.setGene(i, outro.getGene(i));
            
        return novo;   
    };
}   

 