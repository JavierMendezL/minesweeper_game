package controller;


import model.Board;
import model.Cell;
import view.BoardView;

import javax.swing.*;
import java.awt.event.*;

public class BoardController implements ActionListener {

  private BoardView view;
  private Board model;


  public BoardController(BoardView view, Board model) {
    this.model = model;
    this.view = view;

  }

  public void setUpController() {
    view.setGridSize(model.getTotalCellNumber());
    view.createView();
    view.addActionListener(this);
    view.addMouseListenerToCells(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (SwingUtilities.isRightMouseButton(e)) {
          rightClickOn(view.getCellsButtons().indexOf(e.getSource()));
          System.out.println();
        }
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    int i = view.getCellsButtons().indexOf(actionEvent.getSource());

    cellPressed(i);

    view.displayMessage(String.valueOf(i));
    updateView();
  }

  public void cellPressed(int position) {
    model.expandCell(position);
  }

  public void rightClickOn(int position) {
    if (model.getCells()[position].getType() == Cell.FLAG) {
      model.getCells()[position].setType(Cell.DOUBT);
    } else if (model.getCells()[position].getType() == Cell.DOUBT) {
      model.getCells()[position].setType(Cell.EMPTY);
    } else {
      model.getCells()[position].setType(Cell.FLAG);
    }

    view.getCellsButtons().get(position).setText(getLabel(model.getCells()[position].getType()));

  }

  public void updateView() {
    for (int i = 0; i < model.getTotalCellNumber(); i++) {
      if (model.getCells()[i].isVisible()) {
        view.getCellsButtons().get(i).setText(String.valueOf(model.getCells()[i].getValue()));
      }
    }
  }

  private String getLabel(int type) {
    if (type == Cell.FLAG) {
      return "F";
    }
    if (type == Cell.EMPTY) {
      return "";
    }
    if (type == Cell.DOUBT) {
      return "?";
    }
    return "";
  }
}

