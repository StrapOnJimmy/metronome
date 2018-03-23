package app.GUI;

import app.model.entity.*;
import javax.swing.*;
import java.awt.event.*;


public class MetronomeUI extends JFrame {
    private JPanel contentPane;
    private JComboBox quantityButton;
    private JComboBox beatsButton;
    private JSpinner tempoField;
    private JButton startButton;
    private JButton stopButton;
    private JCheckBox accentCheckBox;
    private JComboBox clickSound;
    private JSlider volumeSlider;
    private JOptionPane optionPane;
    private Tact tact;
    private Beat beat;
    private Sound sound;
    private Thread clickThread;



    public MetronomeUI() {
        super("Metronome");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(startButton);

        startButton.addActionListener(e -> {
            if (sound != null){
                sound.stopSound();
            }
            sound = tact.createSound();
            clickThread = new Thread(sound);
            clickThread.start();
        });

        stopButton.addActionListener(e -> sound.stopSound());

        quantityButton.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                Object item = e.getItem();
                tact.setBeatsQuantity(Integer.parseInt(item.toString()));
            }
        });

        beatsButton.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                Object item = e.getItem();
                tact.setBeatsTypes(BeatsTypes.valueOf(item.toString()));
            }
        });

        tempoField.addChangeListener(e -> {
            Object value = tempoField.getValue();
            Double bpm = Double.valueOf(value.toString());
            if (bpm > 400){
                showMessage("Максимальное значение 400");
                tempoField.setValue(400);
            }
            tact.setBpm(Double.valueOf(value.toString()));
        });

        accentCheckBox.addActionListener(e -> {
            if (accentCheckBox.isSelected()){
                tact.setAccentOn(true);
            }else tact.setAccentOn(false);

        });

        clickSound.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object item = e.getItem();
                tact.setInstrument(InstrumentsTypes.valueOf(item.toString()));
            }
        });

        volumeSlider.addChangeListener(e -> {
            int volumeValue = volumeSlider.getValue();
            tact.setVolume(volumeValue);
        });
    }

    private void fillBeatButton() {
        BeatsTypes[] beatsTypes = BeatsTypes.values();
        for (BeatsTypes beatType : beatsTypes
                ) {
            beatsButton.addItem(beatType);
        }
        beatsButton.setSelectedItem(DefaultValues.DEFAULT_BEATS_TYPE);
    }

    private void fillQuantityButton() {
        for (int beatQuantitiy : DefaultValues.beatsQuantities
                ) {
            quantityButton.addItem(beatQuantitiy);
        }
        quantityButton.setSelectedItem(DefaultValues.DEFAULT_BEATS_QUANTITY);
    }

    private void fillTempoField() {
        tempoField.setValue(DefaultValues.DEFAULT_BPM);
    }

    private void fillInstrumentTypes(){
        for (InstrumentsTypes instrument: InstrumentsTypes.values()
             ) {
            clickSound.addItem(instrument);
        }
        clickSound.setSelectedItem(DefaultValues.DEFAULT_INSTRUMENT);
    }

    private void fillVolumeSlider(){
        volumeSlider.setMaximum(200);
        volumeSlider.setValue(DefaultValues.DEFAULT_VOLUME_VALUE);
    }

    private void showMessage(String text){
        optionPane.showMessageDialog(null, text);
    }

    private void initializeMetronome(){
        tact = new Tact();
        beat = tact.createBeat();
        sound = tact.createSound();
    }

    public static void main(String[] args) {
        MetronomeUI mainFrame = new MetronomeUI();
        mainFrame.initializeMetronome();
        mainFrame.fillTempoField();
        mainFrame.fillQuantityButton();
        mainFrame.fillBeatButton();
        mainFrame.fillInstrumentTypes();
        mainFrame.fillVolumeSlider();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
