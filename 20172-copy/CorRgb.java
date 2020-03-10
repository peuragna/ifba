public class CorRgb extends Pixel{
    private int red;
    private int green;
    private int blue;
    
    public CorRgb(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    };
    
    public int getRed(){
        return this.red;
    };
    
    public int getGreen(){
        return this.green;
    };
    
    public int getBlue(){
        return this.blue;
    };
    
    public int getLuminosidade(){
        return (int)((this.getRed()*0.3) + (this.getGreen()*0.59) + (this.getBlue()*0.11)/255)*100;
    };
}
