package controller;


import model.Board;
import model.Cell;
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
    int i = view.getCellsButtons().indexOf(actionEvent.getSource());
    cellPressed(i);

    view.displayMessage(String.valueOf(i));
    updateView();
  }

  public void cellPressed(int position) {
    model.expandCell(position);
  }

  public void updateView(){
    for (int i = 0; i < model.getTotalCellNumber(); i++) {
      if (model.getCells()[i].isVisible()){
        view.getCellsButtons().get(i).setText(String.valueOf(model.getCells()[i].getValue()));
      }
    }
  }
}

