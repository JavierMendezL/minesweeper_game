package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

  private int rows;
  private int cols;
  private int mines;
  private int[] minesPosition;
  private Cell[] cells;


  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }
  public Board(){};

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
    if (numberOfMines<= 0) this.mines = -1;
  }

  public int[] getRandomMinesPosition() {
    try {
      minesPosition = new int[getTotalMines()];
      int []allCells = new int[getTotalCellNumber()];
      List<Integer> integerList = new ArrayList<>();
      for (int i = 0; i < allCells.length; i++) {
        integerList.add(i);
      }
      Collections.shuffle(integerList);

      minesPosition =  integerList.stream().mapToInt(i-> i).toArray();
      return Arrays.copyOfRange(minesPosition, 0, getTotalMines());

    } catch (NegativeArraySizeException exception) {
      return new int[]{-1};
    }
  }

  public void setMinesPosition(int[] minesPosition) {
    this.minesPosition = minesPosition;
    cells = new Cell[getTotalCellNumber()];
    for (int i = 0; i < minesPosition.length; i++) {
      cells[minesPosition[i]] = new Cell(new Mine());
    }
    for (int i = 0; i < cells.length; i++) {
      if (cells[i] == null){
        cells[i] = new Cell(new Number());
      }
    }
  }

  public int[] setNumberMinesOnNeighbours() {//setNumberMinesOnNeighbours
    //int[] minesPositions = getRandomMinesPosition();
    int [] mineSurrounding;
    boolean modified;
    for (int i = 0; i < minesPosition.length; i++) {
      modified = false;
      int minePosition = minesPosition[i];
      mineSurrounding = getCellAroundPosition(minePosition);
      if (minePosition%rows == 0){//left side
        if (minePosition == 0){//top-left
          cells[mineSurrounding[4]].incrementValue();
          cells[mineSurrounding[6]].incrementValue();
          cells[mineSurrounding[7]].incrementValue();
          modified = true;
        }else if((minePosition + rows)==(rows*cols)){//bottom-left
          cells[mineSurrounding[1]].incrementValue();
          cells[mineSurrounding[2]].incrementValue();
          cells[mineSurrounding[4]].incrementValue();
          modified = true;
        }else{//left
          cells[mineSurrounding[1]].incrementValue();
          cells[mineSurrounding[2]].incrementValue();
          cells[mineSurrounding[4]].incrementValue();
          cells[mineSurrounding[6]].incrementValue();
          cells[mineSurrounding[7]].incrementValue();
          modified = true;
        }
      }
      if ((minePosition+1)%rows == 0){//right side
        if (minePosition == rows-1){//top-right
          if (!modified){
            cells[mineSurrounding[3]].incrementValue();
            cells[mineSurrounding[5]].incrementValue();
            cells[mineSurrounding[6]].incrementValue();
            modified =true;
          }
        }else if(minePosition == (rows*cols-1)){//bottom-right
          if (!modified){
            cells[mineSurrounding[0]].incrementValue();
            cells[mineSurrounding[1]].incrementValue();
            cells[mineSurrounding[3]].incrementValue();
            modified = true;
          }
        }else{//right
          if (!modified){
            cells[mineSurrounding[0]].incrementValue();
            cells[mineSurrounding[1]].incrementValue();
            cells[mineSurrounding[3]].incrementValue();
            cells[mineSurrounding[5]].incrementValue();
            cells[mineSurrounding[6]].incrementValue();
            modified = true;
          }
        }
      }
      if(minePosition< rows){ //top
        if (!modified){
          cells[mineSurrounding[3]].incrementValue();
          cells[mineSurrounding[4]].incrementValue();
          cells[mineSurrounding[5]].incrementValue();
          cells[mineSurrounding[6]].incrementValue();
          cells[mineSurrounding[7]].incrementValue();
          //modified = true;
        }
      }else if(minePosition>=(rows*cols-1)-rows){ //bottom
        if (!modified){
          cells[mineSurrounding[0]].incrementValue();
          cells[mineSurrounding[1]].incrementValue();
          cells[mineSurrounding[2]].incrementValue();
          cells[mineSurrounding[3]].incrementValue();
          cells[mineSurrounding[4]].incrementValue();
          //modified = true;
        }

      }else{//regular
        if (!modified){
          cells[mineSurrounding[0]].incrementValue();
          cells[mineSurrounding[1]].incrementValue();
          cells[mineSurrounding[2]].incrementValue();
          cells[mineSurrounding[3]].incrementValue();
          cells[mineSurrounding[4]].incrementValue();
          cells[mineSurrounding[5]].incrementValue();
          cells[mineSurrounding[6]].incrementValue();
          cells[mineSurrounding[7]].incrementValue();
          //modified = true;
        }
      }
    }



    int[] allCells =  new int[cells.length];
    for (int i = 0; i < allCells.length; i++) {
      allCells[i] = cells[i].getValue();
    }
    return allCells;
  }

  public int[] getCellAroundPosition(int position) {
    int topLeft = (position-rows)-1;
    int topRight = (position-rows)+1;
    int top = position-rows;
    int left = position-1;
    int right = position + 1;
    int bottom = position+rows;
    int bottomLeft = (position+rows)-1;
    int bottomRight = (position+rows)+1;

    return new int[]{topLeft,top,topRight, left, right, bottomLeft, bottom, bottomRight};
    //                 0      1   2         3     4         5         6         7
  }


  public int[] getSurroundingPositions(int i) {
    return new int[] {1};
  }
}
