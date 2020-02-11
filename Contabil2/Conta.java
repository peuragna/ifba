public class Conta{
    protected int numero;
    protected double saldo;
    
    public Conta(int numero, double saldo){
        this.saldo = saldo;
        this.numero = numero;
    };
    
    public int getNumero(){
        return this.numero;
    };
    
    public boolean equals(Object o){
        return this.getNumero() == ((Conta)o).getNumero();
    };

    public String toString(){
        return "O numero da conta é" + this.getNumero();
    };
}

