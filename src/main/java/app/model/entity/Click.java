package app.model.entity;

public class Click {
    private Sound sound;

    public Click() {
        setSound();
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound() {
        this.sound = new Sound();
    }

    public void play(){
        sound.playSound();
    }

    public void stop(){
        sound.stopSound();
    }
}
