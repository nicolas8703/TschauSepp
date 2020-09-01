package TschauSepp.Gui;

import TschauSepp.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Nicolas Feige
 *
 * @author Nicolas Feige
 * @version 1.0
 * @date 15.06.2020
 */


public class SpieleGui extends JFrame {
    private JPanel haubt_panel = new JPanel();
    private JPanel oben_panel = new JPanel();
    private JPanel mitte_panel = new JPanel();
    private JPanel unten_panel = new JPanel();
    private JPanel knoepfe_panel = new JPanel();

    private JButton karte1_button = new JButton();
    private JButton karte2_button = new JButton();
    private JButton karte3_button = new JButton();
    private JButton karte4_button = new JButton();
    private JButton karte5_button = new JButton();
    private JButton karte6_button = new JButton();
    private JButton karte7_button = new JButton();
    private JButton karte8_button = new JButton();
    private JButton karte9_button = new JButton();
    private JButton karte10_button = new JButton();
    private JButton karte11_button = new JButton();
    private JButton karte12_button = new JButton();
    private JButton karte13_button = new JButton();
    private JButton karte14_button = new JButton();
    private JButton karte15_button = new JButton();
    private JButton karte16_button = new JButton();
    private JButton karte17_button = new JButton();
    private JButton letzteKarte_button = new JButton();
    private JButton kartenRuecken_button = new JButton();
    private JButton karteAufnehmen_button = new JButton("Karte aufnehmen");
    private JButton seppSagen_button = new JButton("Sepp sagen");
    private JButton tschauSagen_button = new JButton("Tschau sagen");

    private JPanel platzhalter_oben1 = new JPanel();
    private JPanel platzhalter_oben2 = new JPanel();
    private JPanel platzhalter_oben3 = new JPanel();
    private JPanel platzhalter_oben4 = new JPanel();
    private JPanel platzhalter_oben5 = new JPanel();
    private JLabel spielerNamenAnzeige_label = new JLabel();
    private JLabel spielerPunkteAnzeige_label = new JLabel();

    private ArrayList<String> temp1;
    private Spiel spiel;
    private Vector<JButton> kartenButtons = new Vector<>();
    private Vector<String> kartenIDs;

    /**
     * Erstellt das Spiel GUI
     *  Das Spiele GUI wird erstellt und die Namen der Spieler werden mitgegeben.
     *  Das GUI wird mit init() gebaut. Danach werden die Karten Bilder hinzugefügt,angezeigt und die Spielerinfos angezeigt
     *  und eine neue Runde gestartet
     *
     * @param name1 name des Spielers 1
     * @param name2 name des Spielers 2
     * @param name3 name des Spielers 3
     * @param name4 name des Spielers 4
     */
    public SpieleGui(String name1, String name2, String name3, String name4) {
        init();
        Spieler spieler1 = new Spieler(name1);
        Spieler spieler2 = new Spieler(name2);
        Spieler spieler3 = new Spieler(name3);
        Spieler spieler4 = new Spieler(name4);
        spiel = new Spiel(spieler1, spieler2, spieler3, spieler4, 200);
        kartenIDs = new Vector<>();
        kartenBilderHinzufuegen();
        spiel.startRunde(spiel);
        spielerInfosAnzeigen();
        letzteKarte_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/" + spiel.getObersteKarte() + ".gif")));
        kartenBilderAnzeigen();
    }

    /**
     * Die Bilder der Karten werden angezeigt
     * Es wird für jede Karte die der Spieler hat die entsprechende Karte als Gif angezeigt
     * Es wird die oberste Karte auf dem Ablagestapel aktualisiert.
     * Die Karten werden über einen Array als Collection eingelesen. Danach werden sie einfachhalts halber über eine ArrayList in einen Vector umgewandelt
     * Die Buttons in denen keine Karten angezeigt werden müssen, werden deaktiviert
     */
    public void kartenBilderAnzeigen(){
        kartenIDs.clear();
        String listString = spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).stream().map(Object::toString).collect(Collectors.joining(","));
        String[] temp = listString.split(",");
        temp1 = new ArrayList<>(Arrays.asList(temp));
        kartenIDs.addAll(temp1);
        temp1.clear();
        letzteKarte_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/" + spiel.getObersteKarte() + ".gif")));
        for(int i = 0; i < kartenIDs.size();i++){
            kartenButtons.get(i).setEnabled(true);
            kartenButtons.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("images/" + kartenIDs.get(i) + ".gif")));
        }
        //deaktiviert alle nicht genutzten Karten
        for(int i = kartenIDs.size(); i < kartenButtons.size();i++){
            kartenButtons.get(i).setIcon(null);
            kartenButtons.get(i).setEnabled(false);
        }

    }

    /**
     * Die Knöpfe werden dem KartenButtons Vector hinzugefügt
     */
    public void kartenBilderHinzufuegen(){
        kartenButtons.add(karte1_button);
        kartenButtons.add(karte2_button);
        kartenButtons.add(karte3_button);
        kartenButtons.add(karte4_button);
        kartenButtons.add(karte5_button);
        kartenButtons.add(karte6_button);
        kartenButtons.add(karte7_button);
        kartenButtons.add(karte8_button);
        kartenButtons.add(karte9_button);
        kartenButtons.add(karte10_button);
        kartenButtons.add(karte11_button);
        kartenButtons.add(karte12_button);
        kartenButtons.add(karte13_button);
        kartenButtons.add(karte14_button);
        kartenButtons.add(karte15_button);
        kartenButtons.add(karte16_button);
        kartenButtons.add(karte17_button);
    }

    /**
     * Die Spielerinfos werden aktualisierrt und angezeigt
     */
    public void spielerInfosAnzeigen(){
        Spieler aktuellerSpieler = spiel.getAktuellerSpieler();
        String name = aktuellerSpieler.getName();
        spielerNamenAnzeige_label.setText(name);
        int punkte = aktuellerSpieler.getPunktzahl();
        spielerPunkteAnzeige_label.setText("Punkte: " + String.valueOf(punkte));
    }


    /**
     * Das GUI wird initalisiert und die AktionListener für die Knöpfe "Karte ziehen", "Tschau sagen" und "Sepp sagen" werden initalisiert.
     * Ausserdem wird ein AktionListener für alle Kartengemacht, damit die Karten gelegt werden können
     */
    public void init() {
        setTitle("Tschau Sepp");
        setSize(1280, 720);
        setResizable(false);
        getContentPane().add(haubt_panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        haubt_panel.setLayout(new GridLayout(3,1));
        haubt_panel.add(oben_panel);
        oben_panel.setLayout(new GridLayout(1,3));
        oben_panel.add(platzhalter_oben1);
        oben_panel.add(platzhalter_oben3);
        oben_panel.add(platzhalter_oben2);
        platzhalter_oben1.setPreferredSize(new Dimension(540,240));
        platzhalter_oben1.setLayout(new BorderLayout());
        platzhalter_oben1.add(platzhalter_oben5, BorderLayout.SOUTH);
        platzhalter_oben3.setPreferredSize(new Dimension(200,240));
        platzhalter_oben2.setPreferredSize(new Dimension(540,240));
        platzhalter_oben3.setLayout(new GridLayout(1,3));
        platzhalter_oben3.add(letzteKarte_button);
        platzhalter_oben3.add(platzhalter_oben4);
        platzhalter_oben3.add(kartenRuecken_button);
        kartenRuecken_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/karte_rueckseite.png")));
        platzhalter_oben5.setLayout(new GridLayout(2,1));
        platzhalter_oben5.add(spielerNamenAnzeige_label);
        spielerNamenAnzeige_label.setFont(new Font("SansSerif", Font.BOLD, 25));
        platzhalter_oben5.add(spielerPunkteAnzeige_label);
        spielerPunkteAnzeige_label.setFont(new Font("SansSerif", Font.BOLD, 25));

        haubt_panel.add(mitte_panel);
        mitte_panel.setLayout(new GridLayout(1,9));
        mitte_panel.add(karte9_button);
        mitte_panel.add(karte10_button);
        mitte_panel.add(karte11_button);
        mitte_panel.add(karte12_button);
        mitte_panel.add(karte13_button);
        mitte_panel.add(karte14_button);
        mitte_panel.add(karte15_button);
        mitte_panel.add(karte16_button);
        mitte_panel.add(karte17_button);
        karte9_button.setBackground(Color.white);
        karte10_button.setBackground(Color.white);
        karte11_button.setBackground(Color.white);
        karte12_button.setBackground(Color.white);
        karte13_button.setBackground(Color.white);
        karte14_button.setBackground(Color.white);
        karte15_button.setBackground(Color.white);
        karte16_button.setBackground(Color.white);
        karte17_button.setBackground(Color.white);

        haubt_panel.add(unten_panel);
        unten_panel.setLayout(new GridLayout(1,9));
        unten_panel.add(karte1_button);
        unten_panel.add(karte2_button);
        unten_panel.add(karte3_button);
        unten_panel.add(karte4_button);
        unten_panel.add(karte5_button);
        unten_panel.add(karte6_button);
        unten_panel.add(karte7_button);
        unten_panel.add(karte8_button);
        karte1_button.setBackground(Color.white);
        karte2_button.setBackground(Color.white);
        karte3_button.setBackground(Color.white);
        karte4_button.setBackground(Color.white);
        karte5_button.setBackground(Color.white);
        karte6_button.setBackground(Color.white);
        karte7_button.setBackground(Color.white);
        karte8_button.setBackground(Color.white);
        unten_panel.add(knoepfe_panel);
        knoepfe_panel.setLayout(new GridLayout(3,1));
        knoepfe_panel.add(karteAufnehmen_button);
        knoepfe_panel.add(tschauSagen_button);
        knoepfe_panel.add(seppSagen_button);
        karteAufnehmen_button.setFont(new Font("SansSerif", Font.BOLD, 12));
        tschauSagen_button.setFont(new Font("SansSerif", Font.BOLD, 12));
        seppSagen_button.setFont(new Font("SansSerif", Font.BOLD, 12));

        karteAufnehmen_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel nachricht = new JLabel(spiel.getAktuellerSpieler().getName() + " hat eine Karte gezogen.");
                nachricht.setFont(new Font("SansSerif", Font.BOLD, 25));
                JOptionPane.showMessageDialog(null, nachricht);
                spiel.pruefeKarteGeben(spiel.getAktuellerSpieler());
                spielerInfosAnzeigen();
                kartenBilderAnzeigen();
            }
        });
        tschauSagen_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).size() == 2){
                    JLabel nachricht = new JLabel(spiel.getAktuellerSpieler().getName() + " hat Tschau gesagt.");
                    nachricht.setFont(new Font("SansSerif", Font.BOLD, 25));
                    spiel.getAktuellerSpieler().setHatTschau(true);
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }else{
                    JLabel nachricht = new JLabel(spiel.getAktuellerSpieler().getName() + " muss 2 Strafkarte aufnehmen, da er fälschlicherweisse Tschau gesagt hat.");
                    nachricht.setFont(new Font("SansSerif", Font.BOLD, 25));
                    JOptionPane.showMessageDialog(null, nachricht);
                    spiel.pruefeKarteGeben2(spiel.getAktuellerSpieler());
                    spiel.naechsterSpielerBestimmten();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        seppSagen_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).size() == 1){
                    JLabel nachricht = new JLabel(spiel.getAktuellerSpieler().getName() + " hat Sepp gesagt.");
                    nachricht.setFont(new Font("SansSerif", Font.BOLD, 25));
                    JOptionPane.showMessageDialog(null, nachricht);
                    spiel.getAktuellerSpieler().setHatSepp(true);
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }else{
                    JLabel nachricht = new JLabel(spiel.getAktuellerSpieler().getName() + " muss 4 Strafkarte aufnehmen, da er fälschlicherweisse Sepp gesagt hat.");
                    nachricht.setFont(new Font("SansSerif", Font.BOLD, 25));
                    JOptionPane.showMessageDialog(null, nachricht);
                    spiel.pruefeKarteGeben4(spiel.getAktuellerSpieler());
                    spiel.naechsterSpielerBestimmten();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte1_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(0) != null) {
                    String kartenid = kartenIDs.get(0);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(0));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte2_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(1) != null) {
                    String kartenid = kartenIDs.get(1);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(1));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte3_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(2) != null) {
                    String kartenid = kartenIDs.get(2);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(2));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte4_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(3) != null) {
                    String kartenid = kartenIDs.get(3);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(3));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte5_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(4) != null) {
                    String kartenid = kartenIDs.get(4);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(4));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte6_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(5) != null) {
                    String kartenid = kartenIDs.get(5);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(5));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte7_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(6) != null) {
                    String kartenid = kartenIDs.get(6);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(6));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte8_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(7) != null) {
                    String kartenid = kartenIDs.get(7);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(7));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte9_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(8) != null) {
                    String kartenid = kartenIDs.get(8);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(8));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte10_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(9) != null) {
                    String kartenid = kartenIDs.get(9);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(9));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte11_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(10) != null) {
                    String kartenid = kartenIDs.get(10);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(10));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte12_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(11) != null) {
                    String kartenid = kartenIDs.get(11);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(11));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte13_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(12) != null) {
                    String kartenid = kartenIDs.get(12);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(12));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte14_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(13) != null) {
                    String kartenid = kartenIDs.get(13);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(13));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte15_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(14) != null) {
                    String kartenid = kartenIDs.get(14);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(14));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte16_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(15) != null) {
                    String kartenid = kartenIDs.get(15);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(15));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
        karte17_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kartenIDs.get(16) != null) {
                    String kartenid = kartenIDs.get(16);
                    try {
                        spiel.pruefeKarteLegen(spiel.getAktuellerSpieler(), spiel.getSpielerKarten1(spiel.getAktuellerSpieler()).get(16));
                    } catch (InvalideSymbolException ex) {
                    } catch (InvalideZahlException ex) {
                    }
                    revalidate();
                    spielerInfosAnzeigen();
                    kartenBilderAnzeigen();
                }
            }
        });
    }
}
