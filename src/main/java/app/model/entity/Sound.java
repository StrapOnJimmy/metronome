package app.model.entity;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Sound{
    private InstrumentsType instrument;
    private double durabilityBetweenClick;
    private int volumeLevel;
    private MidiChannel[] channels;

    public Sound() {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels= synthesizer.getChannels();
            channels[10].programChange(115);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void playSound(){
        channels[10].noteOn( 65,100);
    }
    public void stopSound(){
        channels[10].noteOff(65);
    }
}
