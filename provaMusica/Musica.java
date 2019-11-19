public class Musica{
    private String titulo;
    private double duraçao;
    private Campo campo;
    private String[] listaArtistas;
    private String genero;
    private String nomeGravadora;
    
    //Construtor
    
    public Musica(String titulo, String genero, String nomeGravadora, 
                  String[] listaArtistas, Campo campo, double duraçao){
                      this.setTitulo(titulo);
                      this.setGenero(genero);
                      this.setNomeGravadora(nomeGravadora);
                      this.setListaArtistas(listaArtistas);
                      this.setCampo(campo);
                      this.setDuraçao(duraçao);
    };
    
    //Setters
    
    private void setTitulo(String titulo){
        this.titulo = titulo;  
    };
    
    private void setGenero(String genero){
        this.genero = genero;
    };
    
    private void setNomeGravadora(String NomeGravadora){
        this.nomeGravadora = nomeGravadora; 
    };
    
    private void setListaArtistas(String[] listaArtistas){
        this.listaArtistas = listaArtistas; 
    };
    
    private void setCampo(Campo campo){
        this.campo = campo; 
    };
    
    private void setDuraçao(double duraçao){
        this.duraçao = duraçao; 
    };
    
    //Getters
    
    public String getTitulo(){
        return this.titulo;
    };
    
    public String getGenero(){
        return this.genero;
    };
    
    public String getNomeGravadora(){
        return this.nomeGravadora;
    };
    
    public String[] getListaArtistas(){
        return this.listaArtistas;
    };
    
    public Campo getCampo(){
        return this.campo;
    };
    
    public double getDuraçao(){
        return this.duraçao;
    };
    
    //Equals
    
    public boolean comparar(String[] outraLista){
        int count=0;
        
        for(String artistas : this.listaArtistas){
            for(String artistas2 : outraLista){
                if(artistas == artistas2)
                    count++;
            }
        }
        
        if(count == this.listaArtistas.length){
            return true;
        }else return false;
    };
    
    public boolean equals(Musica outra){
        if(!(this.titulo == outra.titulo)){
            return false;
        }else if(this.comparar(outra.listaArtistas) && outra.comparar(this.listaArtistas))
            return true;
            else return false;
    };
    
    //Proximidade   
    
    public float calcularProximidade(Musica outra){
        float proximidade = 0f;
        
        if(this.campo == outra.campo)
            proximidade += 1f;
        if(this.nomeGravadora.equals(outra.nomeGravadora))
            proximidade += 1f;
        if(this.genero.equals(outra.genero))
            proximidade += 1f;
        if(this.equals(outra)){
            proximidade += 1f;
        }else proximidade += this.calcularPorcentagem(outra);
        
        return proximidade;
    };   
    
    public float calcularPorcentagem(Musica outra){
          float qtdArtistas = this.listaArtistas.length + outra.listaArtistas.length;
          float artistasCoincidentes = this.compararCount(outra.listaArtistas) + outra.compararCount(this.listaArtistas);
          
          return qtdArtistas/artistasCoincidentes;
    };
    
     public float compararCount(String[] outraLista){
        int count=0;
        
        for(String artistas : this.listaArtistas){
            for(String artistas2 : outraLista){
                if(artistas == artistas2)
                    count++;
            }
        }
        
        return count; 
    };
    
}