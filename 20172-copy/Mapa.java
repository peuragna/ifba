public abstract class Mapa{
   protected Pixel[][] coleção;
   
   public Mapa(int altura, int largura){
       this.coleção = new Pixel[altura][largura];
   };
   
   public Mapa(CorRgb[][] coleção){
       this.coleção = coleção;
   };
   
   public Mapa(CorCmyk[][] coleção){
       this.coleção = coleção;
   };
   
   public int getLargura(){
       return this.coleção[0].length;
   };
   
   public int getAltura(){
       return this.coleção.length;
   };
   
   public Pixel getPixel(int x, int y){
       return this.coleção[x][y];
   };
   
   public void setPixel(int x, int y, Pixel p){
       this.coleção[x][y] = p;
   };
   
   public int getMaiorSimilaridade(Fragmento f){
       int maior = this.coleção[0][0].getSimilaridade(f.segmento[0][0]);
        
       for(int r = 0; r < f.getLargura(); r++)
           for(int c = 0; c < f.getAltura(); c++)
               if(this.coleção[r][c].getSimilaridade(f.segmento[r][c]) > maior)
                   maior = this.coleção[r][c].getSimilaridade(f.segmento[r][c]);
       return maior;
   }; 
}

