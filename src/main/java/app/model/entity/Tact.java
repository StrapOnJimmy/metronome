package app.model.entity;

public class Tact {

    private BeatsType beatsType;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;
    private Click click;

    public Tact(double bpm) {
        this.bpm = bpm;
        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
    }

    public int getBeatsQuantity() {
        return beatsQuantity;
    }

    public void setBeatsQuantity(int beatsQuantity) {
        if (beatsQuantity <= 0){
            return;
        }
        this.beatsQuantity = beatsQuantity;
    }


    public Click createClick() {
        this.click = new Click();
        return click;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        if (bpm <= 0){
            this.bpm = DefaultValues.DEFAULT_BPM;
        } else {
            this.bpm = bpm;
        }
    }

    public Beat createBeat(BeatsType beatsType){
        if(beat == null){
            beat = new Beat(beatsType,bpm);
        }
        return beat;
    }
    public void play(){
        click.play();
        click.stop();
    }
}
