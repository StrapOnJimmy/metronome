package app.GUI;

import app.controller.MetronomeController;
import app.model.entity.*;

import javax.swing.*;
import java.awt.event.*;

public class MetronomeUI extends JDialog {
    private WorkerThread workerThread;
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox quantityButton;
    private JComboBox beatsButton;
    private JTextField tempoField;
    private JButton startButton;
    private JButton stopButton;
    private JCheckBox accentCheckBox;
    private DefaultComboBoxModel comboBoxModel;
    private Tact tact;
    private Click click;
    private Beat beat;




    public MetronomeUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(startButton);
        fillQuantityButton();
        fillBeatButton();
        fillTempoField();
        initializeMetronome();

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workerThread = new WorkerThread(click, beat);
                workerThread.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workerThread.stopPlay();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void fillBeatButton() {
        BeatsTypes[] beatsTypes = BeatsTypes.values();
        for (BeatsTypes beatType : beatsTypes
                ) {
            beatsButton.addItem(beatType);
        }
        beatsButton.setSelectedIndex(2);
    }

    private void fillQuantityButton() {
        for (int beatQuantitiy : DefaultValues.beatsQuantities
                ) {
            quantityButton.addItem(beatQuantitiy);
        }
        quantityButton.setSelectedIndex(3);
    }

    private void fillTempoField() {
        tempoField.setText(String.valueOf(DefaultValues.DEFAULT_BPM));
    }

    private void initializeMetronome(){

        tact = new Tact();
        beat = tact.createBeat();
        click = tact.createClick();
        click.createSound();
    }

    public static void main(String[] args) {
        MetronomeUI dialog = new MetronomeUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
//
//        Tact tact = new Tact(130,8);
//        Beat beat = tact.createBeat(BeatsTypes.EIGHTH);
//        Click click = tact.createClick();
//        click.createSound(InstrumentsTypes.SideStick);
    }
}
