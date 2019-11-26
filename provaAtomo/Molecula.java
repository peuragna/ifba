public class Molecula{
    Atomo[] atomos;
    
    public Atomo getMenor(){
        Atomo menor = this.atomos[0];
        
        for(Atomo atomo : this.atomos)
            if(atomo.getNumeroAtomico() < menor.getNumeroAtomico())
                menor = atomo;
                
        return menor;         
    };
    
}
