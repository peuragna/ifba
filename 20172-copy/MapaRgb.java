public class MapaRgb extends Mapa{
    public CorRgb[][] pixels;
    
   public MapaRgb(int altura, int largura){
       super(altura, largura);
   };

   public MapaRgb(CorRgb[][] coleção){
       super(coleção);
   };
   
   public Pixel getPixel(int x, int y){
       return this.pixels[x][y];
   };
}
