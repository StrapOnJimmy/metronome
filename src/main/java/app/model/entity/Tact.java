package app.model.entity;

public class Tact {

    private BeatsTypes beatsTypes;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;

    public Tact(double bpm) {
        this.bpm = bpm;
        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
    }

    public Tact(double bpm, int beatsQuantity) {
        this.bpm = bpm;
        this.beatsQuantity = beatsQuantity;
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
        Click click = new Click(beatsQuantity);
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

    public Beat createBeat(BeatsTypes beatsTypes){
        if(beat == null){
            beat = new Beat(beatsTypes,bpm);
        }
        return beat;
    }
}
