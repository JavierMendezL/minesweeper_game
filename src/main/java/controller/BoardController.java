package controller;


import model.Board;
import view.BoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {

  private BoardView view;
  private Board model;


  public BoardController(BoardView view, Board model){
    this.model = model;
    this.view = view;

  }

  public void setUpController(){
    view.setGridSize(model.getTotalCellNumber());
    view.createView();
    view.addCalculationListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    String text = ((JButton) actionEvent.getSource()).getText();
    view.displayMessage(text);
  }
}

