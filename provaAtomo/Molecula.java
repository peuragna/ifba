public class Molecula{
    Atomo[] atomos;
    
    public Molecula(int qtdAtomos){
        this.atomos = new Atomo[qtdAtomos];
    };
    
    public void setAtomo(int indice, Atomo atomo){
        this.atomos[indice] = atomo;
    };
    
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
            if(este != null)
                if(atomo.equals(este))
                    qtd++;
        
        return qtd;
    };
    
    public boolean isPresente(Molecula outra){
        for(Atomo outros : outra.atomos)
            if(outros != null)
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
