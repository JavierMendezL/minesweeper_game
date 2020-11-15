package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.Utilities;

public class BoardView extends JFrame {

  private ArrayList<JButton> cellsButtons;
  int cellsSize;


  public ArrayList<JButton> getCellsButtons(){
    return cellsButtons;
  }
  public BoardView() {
    this.setTitle("Board");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setGridSize(int size) {
    cellsSize = size;
  }

  public void createView() {
    addComponents(this.getContentPane());
  }

  private void addComponents(Container container) {
    JPanel mainSection = new JPanel();
    mainSection.setLayout(new GridLayout(10, 10));

    cellsButtons = new ArrayList<>();
    for (int i = 0; i < cellsSize; i++) {
      cellsButtons.add( new JButton(""));
      mainSection.add(cellsButtons.get(i));
      container.add(mainSection, BorderLayout.CENTER);

    }
    this.setSize(new Dimension(600, 900));
    this.setResizable(false);
    this.setVisible(true);
  }



  public void addActionListener(ActionListener listener) {
    for (int i = 0; i < cellsSize; i++) {
      cellsButtons.get(i).addActionListener(listener);
    }
  }
  public void addMouseListenerToCells(MouseListener mouseListener){
    for (int i = 0; i < cellsSize; i++) {
      cellsButtons.get(i).addMouseListener(mouseListener);
    }
  }


  public void displayMessage(String message){
    JOptionPane.showMessageDialog(this, message);
  }


}
