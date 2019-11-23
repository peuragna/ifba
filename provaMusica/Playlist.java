public class Playlist{
    private Musica[] musicas;
    private String nome;
    
    public Playlist(int tamanho, String nome){
        this.musicas = new Musica[tamanho];
        this.setNome(nome);
    };
    
     public Playlist(int tamanho){
        this(tamanho, "Standard");
    };
    
    private void setNome(String nome){
        this.nome = nome;
    };
    
    public String getNome(){
        return this.nome;
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
            aux[i] = this.getMusica(i);
        
        aux[this.musicas.length] = musica;
        this.musicas = aux;
    };
    
    public void removeMusica(int indice){
        Playlist aux = new Playlist(this.musicas.length - 1);
        
        for(int i = 0; i < indice; i++){
            aux.musicas[i] = this.getMusica(i);
        }
        
        for(int i = indice; i < aux.musicas.length; i++){
            aux.musicas[i] = this.getMusica(i + 1);
        }
        this.musicas = aux.musicas;
    };
    
    public Playlist gerarPlaylist(Playlist outra, String nome, double duraçao){
        int indice;
        Playlist novaPlaylist = new Playlist(1, nome);
        
        while(duraçao > 0){
            indice = this.getIndiceMusicaMaisProxima(outra);
            novaPlaylist.addMusica(outra.getMusica(indice));
            duraçao = duraçao - outra.getMusica(indice).getDuraçao();
            outra.removeMusica(indice);
        }
        return novaPlaylist; 
    };
    
    public int getIndiceMusicaMaisProxima(Playlist outra){
        double[] proximidades = new double[this.musicas.length];
        double proximidade = 0;
        double maior = 0;
        int indice = 0;
        
        for(int i = 0; i < outra.musicas.length; i++)
            for(Musica thisMusica : this.musicas){
                if(proximidade < outra.getMusica(i).calcularProximidade(thisMusica))
                     proximidades[i] = proximidade;
            } 
               
        for(int i = 0; i < proximidades.length; i++){
            if(proximidades[i] > maior){
                maior = proximidades[i];
                indice = i;
            }  
        }
        return indice;
    };
}
