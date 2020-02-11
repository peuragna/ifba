public class Lançamento{
    private String descrição;
    private double valor;
    private Conta Cdebito, Ccredito;
    
    public Lançamento(String descrição, double valor, Conta Cdebito, Conta Ccredito){
        this.descrição = descrição;
        this.valor = valor;
        this.Cdebito = Cdebito;
        this.Ccredito = Ccredito;
    };
    
    public void operação(){
        this.Cdebito.debitar();
        this.Ccredito.creditar();
    };
    
    public String toString(){
        return this.descrição + " " + this.valor; 
    };
}
