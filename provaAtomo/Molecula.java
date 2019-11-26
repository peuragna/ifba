public class Molecula{
    Atomo[] atomos;
    
    public Atomo getMenor(){
        Atomo menor = this.atomos[0];
        
        for(Atomo atomo : this.atomos)
            if(atomo.getNumeroAtomico() < menor.getNumeroAtomico())
                menor = atomo;
                
        return menor;         
    };
    
    public int getNumAtomos(Atomo atomo){
        int qtd = 0;
        
        for(Atomo este : this.atomos)
            if(atomo.equals(este))
                qtd++;
        
        return qtd;
    };
    
    public boolean isPresente(Molecula outra){
        for(Atomo outros : outra.atomos)
            if(this.getNumAtomos(outros) == 0)
                return false;
        
        return true;
    };
    
     public boolean isComposto(Molecula outra){
         if(this.isPresente(outra) == true && outra.isPresente(this) == true)
            return true;
         
         return false;
    };
}
