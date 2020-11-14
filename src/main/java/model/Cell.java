package model;

public class Cell{
  private CellState state;

  public Cell(CellState state){
    this.state = state;
    this.state.setCell(this);
  }

  public void incrementValue(){
    state.setValue(1);
  }

  public int getValue(){
    return state.getValue();
  }
}
