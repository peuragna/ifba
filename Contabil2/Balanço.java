public class Balanço{
    protected Conta[] contas;
    
    public Balanço(){
        contas = new Conta[0];
    };
    
    public Conta getConta(int pos){
        return this.contas[pos];
    };
    
    public void addConta(Conta conta){
        Conta[] novas = new Conta[this.contas.length + 1];
        
        for(int iCont = 0; iCont < this.contas.length; iCont++)
          novas[iCont] = this.getConta(iCont);
          
        novas[novas.length - 1] = conta;
        this.contas = novas;

    };
    

}
