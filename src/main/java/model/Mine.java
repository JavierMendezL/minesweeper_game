package model;

public class Mine implements CellState{
  Cell cell;
  @Override
  public void setCell(Cell cell) {
    this.cell = cell;
  }

  @Override
  public int getValue() {
    return -1;
  }

  @Override
  public void setValue(int value) {

  }
}
