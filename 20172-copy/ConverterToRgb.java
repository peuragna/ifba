public class ConverterToRgb implements ConversorCor{
    
    public Mapa getNovoMapa(int altura, int largura){
        return new MapaRgb(altura, largura);
    };
    
    public Pixel converter(Pixel c){
        CorCmyk cor = (CorCmyk)c;
        
        int red = 255 * (1 - cor.getCyan()) * (1 - cor.getKey());
        int green = 255 * (1 - cor.getMagenta()) * (1 - cor.getKey());
        int blue = 255 * (1 - cor.getYellow()) * (1 - cor.getKey());
        
        return new CorRgb(red, green, blue);
    };
}
