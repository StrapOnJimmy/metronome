package app.model.entity;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.io.PrintStream;

public class Sound {
    private Instruments instrument;
    private double durabilityBetweenClick;
    private int volumeLevel;
    private Synthesizer synthesizer;
    MidiChannel[] channels;

    public Sound() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
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
