package app.model.entity;

public class Tact {

    private BeatsTypes beatsTypes;
    private double bpm;
    private int beatsQuantity;
    private Beat beat;
    private InstrumentsTypes instrument;
    private Sound sound;
    private boolean accentOn;
    private int volume;

    public Tact() {
        this.bpm = DefaultValues.DEFAULT_BPM;
        this.beatsQuantity = DefaultValues.DEFAULT_BEATS_QUANTITY;
        this.beatsTypes = DefaultValues.DEFAULT_BEATS_TYPE;
        this.instrument = DefaultValues.DEFAULT_INSTRUMENT;
        this.accentOn = DefaultValues.DEFAULT_ACCENT_ON;
        this.volume = DefaultValues.DEFAULT_VOLUME_VALUE;
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
            sound.setDuration(beat.getDurability());
        } else {
            this.bpm = bpm;
            beat.setBpm(this.bpm);
            sound.setDuration(beat.getDurability());
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
        sound.setDuration(beat.getDurability());
    }

    public void setInstrument(InstrumentsTypes instrument) {
        this.instrument = instrument;
        sound.setInstrumentsType(instrument);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        sound.setVolumeLevel(volume);
    }
}
