public class Atomo{
    private String nome;
    private int[] camadas = new int[7];
    private int numeroAtomico, numeroMassa;
    
    public Atomo(String nome, int numeroAtomico, int numeroMassa){
        this.setNome(nome);
        this.setNumeroAtomico(numeroAtomico);
        this.setNumeroMassa(numeroMassa);
    };
    
    public void setNome(String nome){
        this.nome = nome;
    };
    
    public void setNumeroAtomico(int numeroAtomico){
        this.numeroAtomico = numeroAtomico;
    };
    
    public void setNumeroMassa(int numeroMassa){
        this.numeroMassa = numeroMassa;
    };
    
     public String getNome(){
        return this.nome;
    };
    
    public int getNumeroAtomico(){
        return this.numeroAtomico;
    };
    
    public int getNumeroMassa(){
        return this.numeroMassa;
    };
    
    public boolean equals(Atomo outro){
        return this.numeroAtomico == outro.numeroAtomico;
    };
    
    public int getEletronsCamada(int camada){
        return this.camadas[camada];  
    };
    
    
    
    
}
