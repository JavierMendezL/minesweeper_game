package controller;

import view.BoardView;

import javax.swing.*;
import java.util.ArrayList;

public class MockView extends BoardView {

  ArrayList<JButton> myButtons;

  public MockView(){
    myButtons = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      myButtons.add(new JButton());
    }
  }

  public ArrayList<JButton> getCellsButtons(){
    return this.myButtons;
  }
}
