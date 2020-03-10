public class Atlas{
    private Mapa[] mapas;
    
    public Mapa getMapaMaisSimilar(Fragmento f){
        double maior = 0;
        Mapa aux = null;
        
        for(Mapa m : this.mapas)
            if(m.getSimilaridade(f) > maior){
                maior = m.getSimilaridade(f);
                aux = m;
            }
        return aux;
    };
}
