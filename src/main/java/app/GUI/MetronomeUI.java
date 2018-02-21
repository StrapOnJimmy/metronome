package app.GUI;

import javax.swing.*;
import java.awt.event.*;

public class MetronomeUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox quantityButton;
    private JComboBox beatsButton;
    private JTextField tempoField;
    private JButton StartButton;
    private JButton stopButton;
    private DefaultComboBoxModel comboBoxModel;

    public MetronomeUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(StartButton);

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

    public static void main(String[] args) {
        MetronomeUI dialog = new MetronomeUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}