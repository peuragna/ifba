public class Fragmento{
   public Pixel[][] segmento;
    
   public int getLargura(){
       return this.segmento[0].length;
   };
   
   public int getAltura(){
       return this.segmento.length;
   };
   
   public Pixel getPixel(int x, int y){
       return this.segmento[x][y];
   };
}
