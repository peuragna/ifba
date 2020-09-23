public class Sistema {
    private UnidadeMonitora[] unidades;
    
    public Sistema() {
        this.unidades = new UnidadeMonitora[0];
    };
    
    public String monitorar(float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
        Equipamentos c = new Equipamentos(video, termometro, co2, ch4);
        float dMin = 0;
        int minPos = 0;
       
        for(int i = 0; i < this.unidades.length; i++)
            if(c.isContido(this.unidades[i].getConfiguracao())) { 
                dMin = this.unidades[i].getDistancia(abcissa, ordenada);
                minPos = i;
                break;
            }
            
        for(int i = minPos + 1; i < this.unidades.length; i++)
            if(c.isContido(this.unidades[i].getConfiguracao()) &&
                this.unidades[i].getDistancia(abcissa, ordenada) < dMin) {
                minPos = i;
                dMin = this.unidades[i].getDistancia(abcissa, ordenada);
            }       
        
        this.unidades[minPos].moveTo(abcissa, ordenada);
        return this.unidades[minPos].getId();   
    };
        
    public void addUnidade(UnidadeMonitora unidade) {
        UnidadeMonitora[] u = new UnidadeMonitora[this.unidades.length + 1];
        
        for(int i = 0; i < this.unidades.length; i++)
            u[i] = this.unidades[i];
        
        u[u.length - 1] = unidade;
        this.unidades = u;
    };
}