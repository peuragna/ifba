public class Atlas{
    private Mapa[] mapas;
    
    public Mapa getMapaMaisSimilar(Fragmento f){
        int maior = 0;
        Mapa aux = null;
        
        for(Mapa m : this.mapas)
            if(m.getMaiorSimilaridade(f) > maior){
                maior = m.getMaiorSimilaridade(f);
                aux = m;
            }
        return aux;
    };
}
