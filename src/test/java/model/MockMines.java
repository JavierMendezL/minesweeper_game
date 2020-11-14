package model;

public class MockMines implements CellState{
  private Cell cell;
  private int value;

  @Override
  public void setCell(Cell cell) {
    this.cell = cell;
  }

  @Override
  public int getValue() { return -1; }

  @Override
  public void setValue(int value) { }
}
