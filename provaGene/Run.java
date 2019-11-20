public class Run{
    private final int TAM1 = 7;
    private final int TAM2 = 6;
    private final int PONTO = 3;
    
    Cromossomo cromosso1 = new Cromossomo(TAM1);
    Cromossomo cromosso2 = new Cromossomo(TAM2);
    
    public void ex(){
        
        for(int i = 0; i < TAM1; i++)
            cromosso1.setGene(i, i + 1);
    
        for(int i = 0; i < TAM2; i++)
            cromosso2.setGene(i, 9);
        
        cromosso1.cruzar(cromosso2, PONTO);
        
        System.out.println();
        
        for(int i = 0; i < TAM2; i++){
            System.out.print(cromosso1.getGene(i) + " ");
        }
    
        System.out.println();
    
        for(int i = 0; i < TAM1; i++){
            System.out.print(cromosso2.getGene(i) + " ");
        }
    }; 
}