package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.Utilities;

public class BoardView extends JFrame {

  JButton[] cells;
  int cellsSize;

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

    cells = new JButton[cellsSize];
    for (int i = 0; i < cellsSize; i++) {
      cells[i] = new JButton(Integer.toString(i));
      mainSection.add(cells[i]);
      container.add(mainSection, BorderLayout.CENTER);

    }
    this.setSize(new Dimension(600, 900));
    this.setResizable(false);
    this.setVisible(true);
  }

  public void addCalculationListener(ActionListener listener) {
    for (int i = 0; i < cellsSize; i++) {
      cells[i].addActionListener(listener);
    }
  }

  public void displayMessage(String message){
    JOptionPane.showMessageDialog(this, message);
  }


}
