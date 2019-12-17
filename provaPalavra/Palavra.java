public class Palavra{
    private String conteudo;
    private Palavra[] similares;
    
    public Palavra(String conteudo){
        this.setConteudo(conteudo);
        this.similares = new Palavra[0];
    };
    
    public Palavra(String conteudo, Palavra outra){
        this(conteudo);
        this.addSimilar(outra);
        outra.addSimilar(this);
    };
    
    public void addSimilar(Palavra outra){
        Palavra[] aux = new Palavra[this.similares.length + 1];
        
        for(int iCont = 0; iCont < this.similares.length; iCont++)
            aux[iCont] = this.similares[iCont];
        
        aux[this.similares.length] = outra;
        this.similares = aux;
    };
    
    private void setConteudo(String conteudo){
        this.conteudo = conteudo;
    };
    
    public String getConteudo(){
        return this.conteudo;
    };
    
    public boolean equals(Palavra outra){
        return this.getConteudo().equals(outra.getConteudo());
    };
    
    public boolean hasSimilaridade(Palavra outra){
        for(Palavra palavra : this.similares)
            if(palavra.equals(outra))
                return true;
        
        return false;
    };
    
    public double countSimilares(Palavra outra){
        double count = 0;
        
        for(Palavra palavra : this.similares)
            if(outra.hasSimilaridade(palavra))
                count++;
                    
        return count;
    };
    
    public double getSimilaridade(Palavra outra){
        double nivel = 0;
        
        if(this.equals(outra))
            return 1;
        else if(outra.hasSimilaridade(this)){
                nivel += 0.5;
                nivel += this.countSimilares(outra) / 2*outra.countSimilares(this);
            }
        
        return nivel;
    };
    
    public double getMaior(Texto texto){
        double maior = 0;
        
        for(Palavra outras : texto.palavras)
            if(this.getSimilaridade(outras) > maior)
                maior = this.getSimilaridade(outras);
        
        return maior;
    };
   
}