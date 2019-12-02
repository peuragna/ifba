public class Run{
    private final int TAM1 = 10;
    private final int TAM2 = 8;
    private final int PONTO = 4;
    
    Cromossomo cromosso1 = new Cromossomo(TAM1);
    Cromossomo cromosso2 = new Cromossomo(TAM2);
    
    public void ex(){
        
        for(int i = 0; i < TAM1; i++)
            cromosso1.setGene(i, new Gene(i + 1));
            
        //cromosso1.setGene(TAM1 - 1, null);
    
        for(int i = 0; i < TAM2; i++)
            cromosso2.setGene(i, null);
        
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