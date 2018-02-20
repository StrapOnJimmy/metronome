package app.model.entity;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Sound{
    private int instrument;
    private int volumeLevel = 100;
    private MidiChannel[] channels;

    public Sound(InstrumentsType instrument) {
        getInstrument(instrument);
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels= synthesizer.getChannels();
            channels[9].programChange(0);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void playSound(){
        channels[9].noteOn(instrument,volumeLevel);
    }
    public void stopSound(){
       channels[9].noteOff(instrument);
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    private void getInstrument(InstrumentsType instrument){
        switch (instrument){
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
}
