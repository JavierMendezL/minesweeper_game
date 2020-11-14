package model;

public class Number implements CellState{
  Cell cell;
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
