package app.model.entity;

public class Tact {

    private BeatsType beatsType;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;
    private Click click;

    public Tact(double bpm, int beatsQuantity) {
        this.bpm = bpm;
        this.beatsQuantity = beatsQuantity;
    }

    public int getBeatsQuantity() {
        return beatsQuantity;
    }

    public void setBeatsQuantity(int beatsQuantity) {
        if (beatsQuantity <= 0){
            this.beatsQuantity = DefaultVariables.DEFAULT_BEATS_QUANTITY;
        }
        this.beatsQuantity = beatsQuantity;
    }

    public Click getClick() {
        return click;
    }

    public void createClick() {
        this.click = new Click();
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        if (bpm <= 0){
            this.bpm = DefaultVariables.DEFAULT_BPM;
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
