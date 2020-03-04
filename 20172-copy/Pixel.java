public abstract class Pixel{
    
    public abstract int getLuminosidade();
    
    public int getSimilaridade(Pixel outro){
        return Math.abs(this.getLuminosidade() - outro.getLuminosidade());
    };
}
