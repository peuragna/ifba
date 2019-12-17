public class Texto{
    public Palavra[] palavras;
    
    public double getSimilaridade(Texto outro){
        double soma = 0;
        
        for(Palavra palavras : this.palavras)
            soma = palavras.getMaior(outro);
        
        return soma/this.palavras.length;
    };
    

    
    
}