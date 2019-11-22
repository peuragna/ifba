public class Playlist{
    private Musica[] musicas;
    
    public Playlist(int tamanho){
        this.musicas = new Musica[tamanho];
    };
    
    public Playlist(){
        this(1);
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
    
    
}
