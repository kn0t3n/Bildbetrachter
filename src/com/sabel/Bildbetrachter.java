package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Bildbetrachter extends JFrame {

    private JRadioButton[] jRadioButtons;
    private JButton jButtonPrevious, jButtonNext;
    private JPanel jPanelWest, jPanelSouth;
    private Icon[] icon;
    private ButtonGroup buttonGroup;
    private JLabel jLabel;
    private JScrollPane jScrollPane;
    private EventHandling eh;

    public Bildbetrachter() throws HeadlessException {

        this.setTitle("Bilder");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(400, 400);

        this.initComponents();

        this.eh = new EventHandling();
        this.setVisible(true);
        eh.windowAskBeforeClose(this);
    }


    //change background images + selected RadioButtons
    private void backgroundBild4() {
        jLabel.setIcon(icon[3]);
        jRadioButtons[3].setSelected(true);
    }

    private void backgroundBild3() {
        jLabel.setIcon(icon[2]);
        jRadioButtons[2].setSelected(true);
    }

    private void backgroundBild2() {
        jLabel.setIcon(icon[1]);
        jRadioButtons[1].setSelected(true);
    }

    private void backgroundBild1() {
        jLabel.setIcon(icon[0]);
        jRadioButtons[0].setSelected(true);
    }


    private void initComponents() {

        jPanelSouth = new JPanel();
        jPanelWest = new JPanel();
        jLabel = new JLabel();

        buttonGroup = new ButtonGroup();

        icon = new ImageIcon[4];
        jRadioButtons = new JRadioButton[4];

//        URL url = getClass().getResource("/bild1.jpg");

        for (int i = 0; i < jRadioButtons.length; i++) {
            jRadioButtons[i] = new JRadioButton("Bild " + (i + 1));
            jPanelWest.add(jRadioButtons[i]);
            buttonGroup.add(jRadioButtons[i]);
            icon[i] = new ImageIcon(getClass().getResource("/Bild" + (i + 1) + ".jpg"));
            jRadioButtons[i].addActionListener(new EventHandling());
        }


        backgroundBild1();


        jScrollPane = new JScrollPane(jLabel);

        jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));

        jButtonPrevious = new JButton("Vorheriges Bild");
        jButtonNext = new JButton("Nächstes Bild");
        jButtonPrevious.addActionListener(new EventHandling());
        jButtonNext.addActionListener(new EventHandling());

        jPanelSouth.add(jButtonPrevious);
        jPanelSouth.add(jButtonNext);


        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        this.add(jPanelWest, BorderLayout.WEST);

    }


    public static void main(String[] args) {
        Bildbetrachter b = new Bildbetrachter();
    }

    private class EventHandling implements ActionListener {


        public EventHandling() {
//            initEvents();
        }

        private int getSelectedButton() {
            int selected = -1;
            for (int i = 0; i < jRadioButtons.length; i++) {
                if (jRadioButtons[i].isSelected()) {
                    selected = i;
                }
            }
            return selected;
        }

        private void initEvents() {
//            jRadioButtons[0].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    backgroundBild1();
//                }
//            });
//            jRadioButtons[1].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    backgroundBild2();
//                }
//            });
//            jRadioButtons[2].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    backgroundBild3();
//                }
//            });
//            jRadioButtons[3].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    backgroundBild4();
//                }
//            });
//            jButtonNext.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    switch (getSelectedButton()) {
//                        case 0:
//                            backgroundBild2();
//                            break;
//                        case 1:
//                            backgroundBild3();
//                            break;
//                        case 2:
//                            backgroundBild4();
//                            break;
//                        case 3:
//                            backgroundBild1();
//                            break;
//                    }
//                }
//            });
//            jButtonPrevious.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    switch (getSelectedButton()) {
//                        case 0:
//                            backgroundBild4();
//                            break;
//                        case 1:
//                            backgroundBild1();
//                            break;
//                        case 2:
//                            backgroundBild2();
//                            break;
//                        case 3:
//                            backgroundBild3();
//                            break;
//                    }
//                }
//            });

        }

        public void windowAskBeforeClose(final Bildbetrachter bb) {
            bb.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (JOptionPane.showConfirmDialog(bb,
                            "Wollen Sie das Programm wirklich beenden?", "Programm beenden?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (getSelectedButton()) {
                case 0:
                    backgroundBild1();
                    break;
                case 1:
                    backgroundBild2();
                    break;
                case 2:
                    backgroundBild3();
                    break;
                case 3:
                    backgroundBild4();
                    break;
            }
            if (e.getSource() == jButtonNext) {
                switch (getSelectedButton()) {
                    case 0:
                        backgroundBild2();
                        break;
                    case 1:
                        backgroundBild3();
                        break;
                    case 2:
                        backgroundBild4();
                        break;
                    case 3:
                        backgroundBild1();
                        break;
                }
            }
            if (e.getSource() == jButtonPrevious) {
                switch (getSelectedButton()) {
                    case 0:
                        backgroundBild4();
                        break;
                    case 1:
                        backgroundBild1();
                        break;
                    case 2:
                        backgroundBild2();
                        break;
                    case 3:
                        backgroundBild3();
                        break;
                }
            }
        }
    }


}
