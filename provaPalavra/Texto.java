public class Texto{
    public Palavra[] palavras;
    
    public double getSimilaridade(Texto outro){
        double soma = 0;
        
        for(Palavra palavras : this.palavras)
            soma += outro.getMaior(palavras);
        
        return soma/this.palavras.length;
    };
    
      public double getMaior(Palavra palavra){
        double maior = 0;
        
        for(Palavra outras : this.palavras)
            if(palavra.getSimilaridade(outras) > maior)
                maior = palavra.getSimilaridade(outras);
        
        return maior;
    }; 
}