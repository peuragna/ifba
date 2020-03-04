public class CorCmyk extends Pixel{
    private int cyan;
    private int magenta;
    private int yellow;
    private int key;
    
    public CorCmyk(int cyan, int magenta, int yellow, int key){
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.key = key;
    };
    
    public int getCyan(){
        return this.cyan;
    };
    
    public int getMagenta(){
        return this.magenta;
    };
    
    public int getYellow(){
        return this.yellow;
    };
    
    public int getKey(){
        return this.key;
    };
    
    public int getLuminosidade(){
       return this.getKey();
    };
}
