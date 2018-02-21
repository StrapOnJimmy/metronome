package app.model.entity;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sound {
    private int instrument;
    private int volumeLevel = 200;
    private MidiChannel[] channels;
    private Synthesizer synthesizer;

    public Sound(InstrumentsTypes instrument) {
        getMidiNumberOfInstrument(instrument);
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
            channels[9].programChange(0);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSound(long duration, boolean accentOn, int beatsQuantity) {
        if (accentOn){
            int iterator= 1;
            channels[9].noteOn(DefaultValues.ACCENT, 200);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (iterator < beatsQuantity) {
                channels[9].noteOn(instrument, volumeLevel);
                iterator++;
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            channels[9].noteOn(instrument, volumeLevel);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSound() {
        channels[9].noteOff(instrument);
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    private void getMidiNumberOfInstrument(InstrumentsTypes instrument) {
        switch (instrument) {
            case Cowbell:
                this.instrument = 56;
                break;
            case LowBongo:
                this.instrument = 61;
                break;
            case LowWoodBlock:
                this.instrument = 77;
                break;
            case SideStick:
                this.instrument = 37;
                break;
        }
    }

    public void close() {
        synthesizer.close();
    }
}
