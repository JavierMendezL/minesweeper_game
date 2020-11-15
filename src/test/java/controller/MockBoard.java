package controller;

import model.Board;
import model.Cell;

public class MockBoard extends Board {

  int rows;
  int cols;
  int mines;
  int[] minesPosition;
  Cell[] myCells;

  public MockBoard() {
    rows = 5;
    cols = 5;
    mines = 10;
    minesPosition = new int[]{1, 6, 8, 12, 16, 19, 20, 24};
    myCells = makeCells();
  }

  private Cell[] makeCells() {
    int[] cellArray = new int[]{2, -1, 3, 1, 1, 2, -1, 4, -1, 1, 2, 3, -1, 3, 2, 2, -1, 2, 3, -1, -1, 2, 1, 2, -1};
    Cell[] cells = new Cell[cellArray.length];
    for (int i = 0; i < cellArray.length; i++) {
      if (cellArray[i] == -1) {
        cells[i] = new Cell(Cell.MINE);
      } else {
        cells[i] = new Cell(Cell.NO_MINE);
      }
      if (i == 10) {
        cells[i].setVisible(true);
        cells[i].setState(Cell.FLAG);
      }
    }
    return cells;
  }

  @Override
  public Cell[] getCells() {
    return this.myCells;
  }

  public boolean[] expandCell(int position) {
    return new boolean[]{false};
  }





}
