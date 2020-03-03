public class CorRgb extends Pixel{
    private int red;
    private int green;
    private int blue;
    
    public int getLuminosidade(){
        return (int)(this.red*0.3 + this.green*0.59 + this.blue*0.11)/255;
    };
}
