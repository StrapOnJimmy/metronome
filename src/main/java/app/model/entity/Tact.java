package app.model.entity;

public class Tact {

    private BeatsTypes beatsTypes;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;
    private InstrumentsTypes instrument;
    private Sound sound;
    private boolean accentOn;

    public Tact() {
        this.bpm = DefaultValues.DEFAULT_BPM;
        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
        this.beatsTypes = DefaultValues.DEFAULT_BEATS_TYPE;
        this.instrument = DefaultValues.DEFAULT_INSTRUMENT;
        this.accentOn = DefaultValues.DEFAULT_ACCENT_ON;
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
        sound.setBeatsQuantity(this.beatsQuantity);
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        if (bpm <= 0){
            this.bpm = DefaultValues.DEFAULT_BPM;
            beat.setBpm(this.bpm);
        } else {
            this.bpm = bpm;
            beat.setBpm(this.bpm);
        }
    }

    public Beat createBeat(){
        if(beat == null){
            beat = new Beat(beatsTypes,bpm);
        }
        return beat;
    }

    public Sound createSound() {
        sound = new Sound(instrument, beatsQuantity, accentOn, beat.getDurability());

        return sound;
    }

    public void setAccentOn(boolean accentOn) {
        this.accentOn = accentOn;
        sound.setAccentOn(this.accentOn);
    }

    public void setBeatsTypes(BeatsTypes beatsTypes) {
        this.beatsTypes = beatsTypes;
        beat.setBeatsTypes(this.beatsTypes);
    }
}
