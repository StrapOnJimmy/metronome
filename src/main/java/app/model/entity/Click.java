package app.model.entity;

public class Click {
    private Sound sound;
    private InstrumentsType instrument;



    public Click() {
    }

    public Sound getSound() {
        return sound;
    }

    public void createSound(InstrumentsType instrument) {
        this.sound = new Sound(instrument);
    }

    public void play(){
        sound.playSound();
    }

    public void stop(){
        sound.stopSound();
    }

    public void setInstrument(InstrumentsType instrument) {
        this.instrument = instrument;
    }
}
