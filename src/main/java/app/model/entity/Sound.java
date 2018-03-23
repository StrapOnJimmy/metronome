package app.model.entity;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sound implements Runnable{
    private int instrument;
    private InstrumentsTypes instrumentsType;
    private int volumeLevel = 100;
    private MidiChannel[] channels;
    private Synthesizer synthesizer;
    private volatile Boolean isRunning = true;
    private int beatsQuantity;
    private boolean accentOn;
    private long duration;

    public Sound(InstrumentsTypes instrument, int beatsQuantity, boolean accentOn, long duration) {
        this.accentOn = accentOn;
        this.beatsQuantity = beatsQuantity;
        this.duration = duration;
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

    public void run() {
//        if (isStopped) {
//            isStopped = false;
//        }
        while (isRunning){
            playSound();
        }
    }

    public void playSound() {

        if (accentOn){
            int iterator= 1;
            channels[9].noteOn(DefaultValues.ACCENT, volumeLevel);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {}
            while (iterator < beatsQuantity) {
                if (!isRunning) {
                    break;
                }
                channels[9].noteOn(instrument, volumeLevel);
                iterator++;
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {}
            }
        } else {
            channels[9].noteOn(instrument, volumeLevel);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {}
        }
    }

    public synchronized void stopSound() {
        isRunning = false;
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

    public void setBeatsQuantity(int beatsQuantity) {
        this.beatsQuantity = beatsQuantity;
    }

    public void setAccentOn(boolean accentOn) {
        this.accentOn = accentOn;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setInstrumentsType(InstrumentsTypes instrumentsType) {
        this.instrumentsType = instrumentsType;
        getMidiNumberOfInstrument(instrumentsType);
    }
}
