package app.model.entity;

public class Click {
    private Sound sound;
    private InstrumentsTypes instrument;
    private int beatsQuantity;


    public Click(int beatsQuantity, InstrumentsTypes instrument) {
        this.beatsQuantity = beatsQuantity;
        this.instrument = instrument;
    }

    public Sound getSound() {
        return sound;
    }

    public void createSound() {
        this.sound = new Sound(instrument);
    }

    public void play(long duration, boolean accentOn){
        sound.playSound(duration,accentOn, beatsQuantity);
    }

    public void stop(){
        sound.stopSound();
    }

    public void setInstrument(InstrumentsTypes instrument) {
        this.instrument = instrument;
    }
}
