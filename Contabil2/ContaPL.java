public class ContaPL extends Conta{
    
    public ContaPL(int numero, double saldo){
        super(numero, saldo);
    };
    
    public void debitar(double valor){
        this.saldo -= valor;
    };
    
    public void creditar(double valor){
        this.saldo += valor;
    };
}
