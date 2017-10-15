package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bildbetrachter extends JFrame {

    private JRadioButton[] jRadioButtons;
    private JButton jButtonPrevious, jButtonNext;
    private JPanel jPanelWest, jPanelSouth, jPanelCenter;
    private Icon[] icon;
    private ButtonGroup buttonGroup;
    private JLabel jLabel;
    private JScrollPane jScrollPane;

    public Bildbetrachter() throws HeadlessException {

        this.setTitle("Bilder");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.initComponents();
        this.initEvents();

        this.setVisible(true);
    }

    private void initEvents() {
        for (int i = 0; i < 4; i++) {
            jRadioButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
    }


    private void initComponents() {
        jPanelSouth = new JPanel();
        jPanelWest = new JPanel();
        jPanelCenter = new JPanel();

        buttonGroup = new ButtonGroup();

        icon = new Icon[4];


        jRadioButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            jRadioButtons[i] = new JRadioButton("Bild " + (i + 1));
            jPanelWest.add(jRadioButtons[i]);
            buttonGroup.add(jRadioButtons[i]);
            icon[i] = new ImageIcon("src/com/sabel/bilder/Bild" + (i + 1) + ".jpg");
        }

        jLabel = new JLabel(icon[0]);
        jScrollPane = new JScrollPane(jLabel);

        jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));

        jButtonPrevious = new JButton("Vorheriges Bild");
        jButtonNext = new JButton("Nächstes Bild");

        jPanelSouth.add(jButtonPrevious);
        jPanelSouth.add(jButtonNext);


        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        this.add(jPanelWest, BorderLayout.WEST);

    }


    public static void main(String[] args) {
        Bildbetrachter b = new Bildbetrachter();
    }


}
