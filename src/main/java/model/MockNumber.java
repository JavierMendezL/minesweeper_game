package model;

public class MockNumber implements CellState{
  Cell cell;
  CellState state;
  Number number;

  private int value;

  public void setCell(Cell cell){
    this.cell = cell;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public void setValue(int value) {
    this.value+= value;
  }


}
