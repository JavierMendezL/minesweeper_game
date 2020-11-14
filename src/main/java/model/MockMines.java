package model;

public class MockMines implements CellState{
  Cell cell;
  Mine mine;
  CellState state;

  private int value;

  @Override
  public void setCell(Cell cell) {
    this.cell = cell;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public void setValue(int value) { }
}
