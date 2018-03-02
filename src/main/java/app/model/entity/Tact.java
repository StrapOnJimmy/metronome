package app.model.entity;

public class Tact {

    private BeatsTypes beatsTypes;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;
    private InstrumentsTypes instrument;
    private Click click;

    public Tact() {
        this.bpm = DefaultValues.DEFAULT_BPM;
        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
        this.beatsTypes = DefaultValues.DEFAULT_BEATS_TYPE;
        this.instrument = DefaultValues.DEFAULT_INSTRUMENT;
    }

//    public Tact(double bpm) {
//        this.bpm = bpm;
//        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
//    }

//    public Tact(double bpm, int beatsQuantity) {
//        this.bpm = bpm;
//        this.beatsQuantity = beatsQuantity;
//    }

    public int getBeatsQuantity() {
        return beatsQuantity;
    }

    public void setBeatsQuantity(int beatsQuantity) {
        if (beatsQuantity <= 0){
            return;
        }
        this.beatsQuantity = beatsQuantity;
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

    public Beat createBeat(){
        if(beat == null){
            beat = new Beat(beatsTypes,bpm);
        }
        return beat;
    }

    public Click createClick() {
        click = new Click(beatsQuantity,instrument);
        return click;
    }
}
