package model;

public class MockNumber implements CellState{
  private Cell cell;
  private int value = 3;

  public void setCell(Cell cell){
    this.cell = cell;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public void setValue(int value) {this.value+=value;}


}
