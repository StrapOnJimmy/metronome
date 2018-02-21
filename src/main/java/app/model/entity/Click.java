package app.model.entity;

public class Click {
    private Sound sound;
    private InstrumentsTypes instrument;
    int beatsQuantity;


    public Click(int beatsQuantity) {
        this.beatsQuantity = beatsQuantity;
    }

    public Sound getSound() {
        return sound;
    }

    public void createSound(InstrumentsTypes instrument) {
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
