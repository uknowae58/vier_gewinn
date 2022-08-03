package tuc.isse.Projektaufgabe1.view;

import org.w3c.dom.html.HTMLTableRowElement;
import tuc.isse.Projektaufgabe1.model.Bord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VierGewinntFrame extends JFrame implements BordObserver {
    protected Bord bord;
    protected ArrayList<JButton> jButtons;
    protected JPanel buttonPanel;
    protected Graphics graphics;
    protected JPanel cellPanel;
    protected ArrayList<JPanel>cellPanels;
    protected JPanel infoPanel;
    protected JLabel jlabel;
    protected ObservableBord observableBord;
    protected int[] row;
    protected JButton loadButton;
    protected JButton saveButton;
    private JLabel infos;
    private ObservableBord observable;
    private ArrayList<JButton> buttons;


    public VierGewinntFrame(Bord bord){
        loadButton = new JButton("load");
        loadButton.setActionCommand("8");
        saveButton = new JButton("save");
        saveButton.setActionCommand("9");
        observableBord = new ObservableBord();
        cellPanels = new ArrayList<JPanel>();
        cellPanel = new JPanel();
        buttonPanel = new JPanel();
        infoPanel = new JPanel();
        jlabel = new JLabel();
        jlabel.setText("");
        infoPanel.add(jlabel);
        infoPanel.add(loadButton);
        infoPanel.add(saveButton);

        observableBord.addObserver(this);
        GridLayout gridLayout = new GridLayout(7,7);
        gridLayout.setHgap(5);
        gridLayout.setVgap(10);
        cellPanel.setLayout(gridLayout);
        setLayout(new GridLayout(2,0));

        /*
         * We draw the buttons above the cells
         */

        jButtons = new ArrayList<JButton>();
        this.setBackground(Color.DARK_GRAY);
        for(int i= 1; i<=7;i++){
            jButtons.add(new JButton(String.valueOf(i)));
            jButtons.get(i-1).setActionCommand(String.valueOf(i));
            cellPanel.add(jButtons.get(i-1));
        }
        /*
         * We draw the cells with the witw color
         */
        for (int i=0;i<42;i++){
            cellPanels.add(new JPanel());
            cellPanels.get(i).setBackground(Color.WHITE);
            cellPanel.add(cellPanels.get(i));
        }
        add(cellPanel);
        add(infoPanel);


        this.bord = bord;
        row = new int[7];
        for (int i = 0; i<7;i++){
            row[i] = 6;
        }
        setTitle("VierGewinn");
        setResizable(false);
        setSize(610,377);
        setVisible(true);
    }

    /**
     * addButtonListener add a button
     * @param listener
     */
    public void addButtonListener(ActionListener listener){
        for(JButton j : jButtons){
            j.addActionListener(listener);
        }
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
    }

    /**
     * removeButtonListener remove a button
     * @param listener
     */
    public void removeButtonListener(ActionListener listener){
        for(JButton j : jButtons){
            j.removeActionListener(listener);
        }
        loadButton.removeActionListener(listener);
        saveButton.removeActionListener(listener);
    }


    /**
     * update gibt eine Farbe zurück
     * @param bord
     */
    @Override
    public void update(ObservableBord bord) {
        for (int row = 5; row >= 0; row--) {
            for (int col = 0; col < 7; col++) {
                if (bord.getTokenColor(row, col) != null) {
                    if (bord.getTokenColor(row, col).equals(tuc.isse.Projektaufgabe1.model.Color.RED)) {
                        this.cellPanels.get(7 * row + col).setBackground(Color.RED);
                    } else {
                        this.cellPanels.get(7 * row + col).setBackground(Color.YELLOW);
                    }
                }
            }
        }

    }

}
