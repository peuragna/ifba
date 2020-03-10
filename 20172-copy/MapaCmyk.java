public class MapaCmyk extends Mapa{
   public CorCmyk[][] pixels;
   
   public MapaCmyk(int altura, int largura){
       super(altura, largura);
   };
   
   public MapaCmyk(CorCmyk[][] coleção){
       super(coleção);
   };
   
   public Pixel getPixel(int x, int y){
       return this.pixels[x][y];
   };
}
