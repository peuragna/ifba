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
   
   public abstract Pixel getPixel(int x, int y);
   
   public void setPixel(int x, int y, Pixel p){
       this.coleção[x][y] = p;
   };
   
   private double getSimilaridade(int x, int y, Fragmento f){
       double similaridade = 0;
       
       for(int xCont = x, xFrag = 0; xCont < x + f.getAltura(); xCont++, xFrag++)
            for(int yCont = y, yFrag = 0; yCont < y + f.getLargura(); yCont++, yFrag++)
                similaridade += this.getPixel(xCont, yCont).getSimilaridade(f.getPixel(xFrag, yFrag));
       similaridade/=(f.getAltura() * f.getLargura());
       return similaridade;
   };
   
   public double getSimilaridade(Fragmento f){
       double similaridade = 0;
       
       for(int xCont = 0; xCont < this.getAltura() - f.getAltura(); xCont++)
            for(int yCont = 0; yCont < this.getLargura() - f.getLargura(); yCont++){
                double similaridadeAtual = this.getSimilaridade(xCont, yCont, f);
                if(similaridadeAtual > similaridade)
                    similaridade = similaridadeAtual;
                }
       return similaridade;
   }; 
}

