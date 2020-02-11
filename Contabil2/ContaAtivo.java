public class ContaAtivo extends Conta{
    
    public ContaAtivo(int numero, double saldo){
        super(numero, saldo);
    };
    
    public void debitar(double valor){
        this.saldo += valor;
    };
    
    public void creditar(double valor){
        this.saldo -= valor;
    };
}