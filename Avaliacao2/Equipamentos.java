public class Equipamentos {
    private boolean video, termometro, co2, ch4;
    
    public Equipamentos(boolean video, boolean termometro, boolean co2, boolean ch4) {
        this.setVideo(video);
        this.setTermometro(termometro);
        this.setCo2(co2);
        this.setCh4(ch4);
    };
    
    public boolean isContido(Equipamentos outro) {
        if(this.isVideo() && !outro.isVideo())
            return false;
        if(this.isTermometro() && !outro.isTermometro())
            return false;
        if(this.isCo2() && !outro.isCo2())
            return false;
        if(this.isCh4() && !outro.isCh4())
            return false;
                    
        return true;
    };
    
    public boolean equals(Equipamentos outro) {
        return  this.isVideo() == outro.isVideo() &&
                this.isTermometro() == outro.isTermometro() &&
                this.isCo2() == outro.isCo2() &&
                this.isCh4() == outro.isCh4();      
    };      
    
    public boolean isVideo() {
        return video;
    };

    public void setVideo(boolean video) {
        this.video = video;
    };

    public boolean isTermometro() {
        return termometro;
    };

    public void setTermometro(boolean termometro) {
        this.termometro = termometro;
    };

    public boolean isCo2() {
        return co2;
    };

    public void setCo2(boolean co2) {
        this.co2 = co2;
    };

    public boolean isCh4() {
        return ch4;
    };

    public void setCh4(boolean ch4) {
        this.ch4 = ch4;
    };
}
