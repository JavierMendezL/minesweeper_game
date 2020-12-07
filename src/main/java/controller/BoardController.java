package controller;

import model.Board;
import model.Cell;
import view.BoardView;


public class BoardController {
  BoardView view;
  Board model;
  TerminalScanner terminalScanner;


  public BoardController(BoardView view, Board model, TerminalScanner terminalScanner) {
    this.view = view;
    this.model = model;
    this.terminalScanner = terminalScanner;
  }

  public int askAction() {
    System.out.println("Actions to do:");
    System.out.println("[0] Open position");
    System.out.println("[1] Put flag");
    System.out.println("[2] Put question mark");
    return terminalScanner.readNumberFromTerminal(2);
  }

  public int askPosition(int maxCols, String name) {
    System.out.println("Choose " + name);
    return terminalScanner.readNumberFromTerminal(maxCols - 1);
  }

  private void setUpGame() {
    this.view.setUpView(model.getRows(), model.getCols());
    view.drawBoard();
  }

  private int convertCoordinate(int row, int cols) {
    return (row * model.getRows()) + cols;
  }

  private void drawPlayingBoard() {
    for (int i = 0; i < model.getTotalCellNumber(); i++) {
      if (model.getCells()[i].isVisible()) {
        if (model.getCells()[i].getValue() == Cell.MINE) {
          view.drawInCell(i, "*");
        }
        if (model.getCells()[i].getType() == Cell.NO_MINE) {
          view.drawInCell(i, String.valueOf(model.getCells()[i].getValue()));
        }
        if (model.getCells()[i].getType() == Cell.EMPTY) {
          view.drawInCell(i, "0");
        }
      }
    }
  }

  public void startGame() {
    setUpGame();
    int actionToPerform;
    int col;
    int row;
    while (!model.isGameOver() && !model.isGameFinished()) {
      actionToPerform = askAction();
      switch (actionToPerform) {
        case 0:
          row = askPosition(model.getRows(), "row");
          col = askPosition(model.getRows(), "column");
          model.expandCell(convertCoordinate(row, col));
          drawPlayingBoard();
          view.drawBoard();
          break;
        case 1:
          row = askPosition(model.getRows(), "row");
          col = askPosition(model.getRows(), "column");
          model.changeState(convertCoordinate(row, col), Cell.FLAG);
          view.drawInCell(convertCoordinate(row, col), "F");
          view.drawBoard();
          break;
        case 2:
          row = askPosition(model.getRows(), "row");
          col = askPosition(model.getRows(), "column");
          model.changeState(convertCoordinate(row, col), Cell.DOUBT);
          view.drawInCell(convertCoordinate(row, col), "?");
          view.drawBoard();
          break;
        default:
          break;
      }
      if (model.isGameOver()) {
        System.out.println("You lost the game :(");
      }
      if (model.isGameFinished()) {
        System.out.println("You win the game :)");
      }
    }
  }

}



