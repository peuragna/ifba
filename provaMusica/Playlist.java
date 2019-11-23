public class Playlist{
    private Musica[] musicas;
    
    public Playlist(int tamanho){
        this.musicas = new Musica[tamanho];
    };
    
    public Playlist(){
        this(1);
    };
    
    public Musica getMusica(int indice){
        return this.musicas[indice];
    };
    
    public Musica[] getLista(){
        return this.musicas;
    };
    
    public void addMusica(Musica musica){
        Musica[] aux = new Musica[this.musicas.length + 1];
        
        for(int i = 0; i < this.musicas.length; i++)
            aux[i] = this.musicas[i];
        
        aux[this.musicas.length] = musica;
        this.musicas = aux;
    };
    
    public void removeMusica(int indice){
        this.musicas[indice] = null;
    }
    
    public Playlist gerarPlaylist(Playlist outra, String nome, double duraçao){
        int indice;
        Playlist novaPlaylist = new Playlist();
        
        while(duraçao > 0){
            indice = this.getMusicaProxima(outra);
            novaPlaylist.addMusica(outra.getMusica(indice));
            duraçao = duraçao - outra.getMusica(indice).getDuraçao();
            
            outra.removeMusica(indice);
        }
        
        return novaPlaylist; 
    };
    
    public int getMusicaProxima(Playlist outra){
        double[] proximidades = new double[this.musicas.length];
        double maior = 0;
        int indice = 0;
        
        for(int i = 0; i < this.musicas.length; i++)
            for(Musica outraMusica : outra.musicas)
                proximidades[i] = this.musicas[i].calcularProximidade(outraMusica);
               
        for(int i = 0; i < proximidades.length; i++)
            if(proximidades[i] > maior){
                maior = proximidades[i];
                indice = i;
            }
            
        return indice;
    };
}
