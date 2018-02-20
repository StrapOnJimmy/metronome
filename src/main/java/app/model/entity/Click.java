package app.model.entity;

public class Click {
    private Sound sound;
    private InstrumentsType instrument;

    public void setInstrument(InstrumentsType instrument) {
        this.instrument = instrument;
    }

    public Click() {
        setSound();
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound() {
        this.sound = new Sound(115);
    }

    public void play(){
        sound.playSound();
    }

    public void stop(){
        sound.stopSound();
    }
}
