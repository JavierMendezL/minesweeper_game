package model;


public class Board {

  private int rows;
  private int cols;
  private int mines;
  private int[] minesPosition;
  private Cell[] cells;
  private IRandomMinesGenerator generator;

  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  public void setGenerator(IRandomMinesGenerator generator) {
    this.generator = generator;
  }

  public Board() {
  }

  public int getCols() {
    return cols;
  }

  public int getRows() {
    return rows;
  }

  public Cell[] getCells() {
    return cells;
  }

  public void setRows(int i) {
    this.rows = i;
    if (i <= 0) {
      this.rows = -1;
    }
  }

  public void setCols(int i) {
    this.cols = i;
    if (i <= 0) {
      this.cols = -1;
    }
  }

  public int getTotalCellNumber() {
    if (cols <= 0 || rows <= 0) return -1;
    return rows * cols;
  }

  public int getTotalMines() {
    return mines;
  }

  public void createMines() {
    mines = getTotalCellNumber() / 3;
    if (getTotalCellNumber() / 3 < 1) {
      mines = -1;
    }
  }

  public void createMines(int numberOfMines) {
    this.mines = numberOfMines;
    if (numberOfMines <= 0) this.mines = -1;
  }

  public int[] getRandomMinesPosition() {
    return generator.generate(rows, cols, getTotalMines());
  }

  public void setMinesPosition(int[] minesPosition) {
    this.minesPosition = minesPosition;
    cells = new Cell[getTotalCellNumber()];
    for (int minePosition : minesPosition) {
      cells[minePosition] = new Cell(Cell.MINE);
    }
    for (int i = 0; i < cells.length; i++) {
      if (cells[i] == null) {
        cells[i] = new Cell(Cell.EMPTY);
      }
    }
  }

  public int[] setNumberMinesOnNeighbours() {//setNumberMinesOnNeighbours
    int[] mineSurrounding;
    for (int minePosition : minesPosition) {
      mineSurrounding = getSurroundingPositions(minePosition);
      for (int neighbourPosition : mineSurrounding) {
        if (neighbourPosition != -1) {
          cells[neighbourPosition].incrementValue();
        }
      }
    }

    int[] allCells = new int[cells.length];
    for (int i = 0; i < allCells.length; i++) {
      allCells[i] = cells[i].getValue();
    }
    return allCells;
  }

  public int[] getCellAroundPosition(int position) {
    int topLeft = (position - cols) - 1;
    int topRight = (position - cols) + 1;
    int top = position - cols;
    int left = position - 1;
    int right = position + 1;
    int bottom = position + cols;
    int bottomLeft = (position + cols) - 1;
    int bottomRight = (position + cols) + 1;

    return new int[]{topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight};
    //                 0      1   2         3     4         5         6         7
  }


  public int[] getSurroundingPositions(int position) {
    int[] mineSurrounding = getCellAroundPosition(position);

    if (position % cols == 0) {//left side

      if (position == 0) {//top-left
        return new int[]{-1, -1, -1, -1, mineSurrounding[4], -1, mineSurrounding[6], mineSurrounding[7]};

      } else if ((position + cols) == (rows * cols)) {//bottom-left
        return new int[]{-1, mineSurrounding[1], mineSurrounding[2], -1, mineSurrounding[4], -1, -1, -1};

      } else {//left
        return new int[]{-1, mineSurrounding[1], mineSurrounding[2], -1, mineSurrounding[4], -1, mineSurrounding[6], mineSurrounding[7]};

      }
    }
    if ((position + 1) % cols == 0) {//right side
      if (position == cols - 1) {//top-right
        return new int[]{-1, -1, -1, mineSurrounding[3], -1, mineSurrounding[5], mineSurrounding[6], -1};

      } else if (position == (rows * cols - 1)) {//bottom-right
        return new int[]{mineSurrounding[0], mineSurrounding[1], -1, mineSurrounding[3], -1, -1, -1, -1};

      } else {//right
        return new int[]{mineSurrounding[0], mineSurrounding[1], -1, mineSurrounding[3], -1, mineSurrounding[5], mineSurrounding[6], -1};
      }
    }
    if (position < cols) { //top
      return new int[]{-1, -1, -1, mineSurrounding[3], mineSurrounding[4], mineSurrounding[5], mineSurrounding[6], mineSurrounding[7]};

    } else if (position >= (rows * cols - 1) - cols) { //bottom
      return new int[]{mineSurrounding[0], mineSurrounding[1], mineSurrounding[2], mineSurrounding[3], mineSurrounding[4], -1, -1, -1};

    } else {//regular
      return new int[]{mineSurrounding[0], mineSurrounding[1], mineSurrounding[2], mineSurrounding[3], mineSurrounding[4], mineSurrounding[5], mineSurrounding[6], mineSurrounding[7]};
    }
  }

  public boolean[] expandCell(int positionToExpand) {
    boolean[] cellBoard = new boolean[cells.length];
    if (cells[positionToExpand].getState() != Cell.FLAG) {
      cells[positionToExpand].setVisible(true);
      cellBoard[positionToExpand] = true;
      if (cells[positionToExpand].getValue() == 0) {
        expandCellRecursive(positionToExpand, cellBoard);
      }
    }
    for (int i = 0; i < cellBoard.length; i++) {
      if (cellBoard[i]) {
        cells[i].setVisible(true);
      }
    }
    return cellBoard;
  }

  public void expandCellRecursive(int positionToExpand, boolean[] cellBoard) {
    int[] surroundingPositions = getSurroundingPositions(positionToExpand);
    for (int surroundingPosition : surroundingPositions) {
      if (surroundingPosition != -1) {
        if (cells[surroundingPosition].getValue() == 0) {
          if (!cellBoard[surroundingPosition]) {
            cellBoard[surroundingPosition] = true;
            expandCellRecursive(surroundingPosition, cellBoard);
          }
        } else {
          if (cells[surroundingPosition].getValue() > 0) {
            if (!cellBoard[surroundingPosition]) {
              cellBoard[surroundingPosition] = true;
            }
          }
        }
      }
    }
  }

  public boolean isGameOver() {
    for (int minePosition : minesPosition) {
      if (cells[minePosition].isVisible()) {
        return true;
      }
    }
    return false;
  }


  public void changeState(int position, int state) {
    cells[position].setState(state);
  }

  public boolean isGameFinished() {
    boolean finished = true;

    for (Cell cell : cells) {
      if (cell.getType() == Cell.MINE && cell.getState() != Cell.FLAG) {
        finished = false;
      }
      if (!cell.isVisible() && cell.getType() != Cell.MINE) {
        finished = false;
      }
    }

    return finished;
  }
}

