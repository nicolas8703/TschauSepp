package TschauSepp.Gui;

import TschauSepp.Model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Nicolas Feige
 *
 * @author Nicolas Feige
 * @version 1.0
 * @date 15.06.2019
 */


public class MenueGui extends JFrame {

    private JPanel hauptPanel = new JPanel();
    private JPanel spieler1Panel = new JPanel();
    private JPanel spieler2Panel = new JPanel();
    private JPanel spieler3Panel = new JPanel();
    private JPanel spieler4Panel = new JPanel();
    private JLabel spieler1Titel = new JLabel("Name:");
    private JLabel spieler2Titel = new JLabel("Name:");
    private JLabel spieler3Titel = new JLabel("Name:");
    private JLabel spieler4Titel = new JLabel("Name:");
    private JTextField spieler1Eingabe = new JTextField();
    private JTextField spieler2Eingabe = new JTextField();
    private JTextField spieler3Eingabe = new JTextField();
    private JTextField spieler4Eingabe = new JTextField();
    private JButton spielStart = new JButton("Start");
    private String spieler1Name;
    private String spieler2Name;
    private String spieler3Name;
    private String spieler4Name;

    /**
     *Hier wird das ganze Programm gestartet, indem ein neues MenueGui erstellt wird
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MenueGui g = new MenueGui();
    }


    /**
     * Hier wird das MenueGui initialisiert und der AktionListener für den StartKnopf
     */
    MenueGui(){
        super("Tschau Sepp");
        getContentPane().add(hauptPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,300);
        setResizable(false);

        hauptPanel.setLayout(new GridLayout(5,1));
        hauptPanel.add(spieler1Panel);
        spieler1Panel.setLayout(new GridLayout(2,1));
        spieler1Panel.add(spieler1Titel);
        spieler1Panel.add(spieler1Eingabe);

        hauptPanel.add(spieler2Panel);
        spieler2Panel.setLayout(new GridLayout(2,1));
        spieler2Panel.add(spieler2Titel);
        spieler2Panel.add(spieler2Eingabe);

        hauptPanel.add(spieler3Panel);
        spieler3Panel.setLayout(new GridLayout(2,1));
        spieler3Panel.add(spieler3Titel);
        spieler3Panel.add(spieler3Eingabe);

        hauptPanel.add(spieler4Panel);
        spieler4Panel.setLayout(new GridLayout(2,1));
        spieler4Panel.add(spieler4Titel);
        spieler4Panel.add(spieler4Eingabe);

        hauptPanel.add(spielStart);
        spielStart.setFont(new Font("SansSerif", Font.BOLD, 12));

        spielStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(spieler1Eingabe.getText().isEmpty() || spieler2Eingabe.getText().isEmpty() ||spieler3Eingabe.getText().isEmpty() ||spieler4Eingabe.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Bitte alle Spielernamen eingeben!","Fehlermeldung",JOptionPane.WARNING_MESSAGE);
                }else if(spieler1Eingabe.getText().length() > 20 || spieler2Eingabe.getText().length() > 20 ||spieler3Eingabe.getText().length() > 20 ||spieler4Eingabe.getText().length() > 20){
                    JOptionPane.showMessageDialog(null,"Alle Spielernamen dürfen maximal 20 Zeichen sein!","Fehlermeldung",JOptionPane.WARNING_MESSAGE);
                }else if(spieler1Eingabe.getText().length() < 2 || spieler2Eingabe.getText().length() < 2 ||spieler3Eingabe.getText().length() < 2 ||spieler4Eingabe.getText().length() < 2){
                    JOptionPane.showMessageDialog(null,"Alle Spielernamen müssen mindestens 2 Zeichen lang sein!","Fehlermeldung",JOptionPane.WARNING_MESSAGE);
                }else {
                    spieler1Name = spieler1Eingabe.getText();
                    spieler2Name = spieler2Eingabe.getText();
                    spieler3Name = spieler3Eingabe.getText();
                    spieler4Name = spieler4Eingabe.getText();
                    dispose();
                    new SpieleGui(spieler1Name, spieler2Name, spieler3Name, spieler4Name).setVisible(true);
                }
            }
        });
    }
}

