public class Run{
    private final int TAM1 = 3;
    private final int TAM2 = 4;
    
    Molecula mol1 = new Molecula(TAM1);
    Molecula mol2 = new Molecula(TAM2);
    
    
    public boolean ex(){
        
        mol1.setAtomo(0, new Atomo("H", 1, 10));
        mol1.setAtomo(1, new Atomo("H", 1, 10));
        mol1.setAtomo(2, new Atomo("O", 8, 10));
        
        mol2.setAtomo(0, new Atomo("H", 1, 10));
        mol2.setAtomo(1, new Atomo("H", 1, 10));
        mol2.setAtomo(2, new Atomo("H", 1, 10));
        mol2.setAtomo(2, new Atomo("O", 8, 10));
        
        return mol1.isComposto(mol2);
    };
    
    
    
    
    
    
    
    
    
}
