package model;

public class Cell{
  public static final int NUMBER = -2; //CANVIAR
  public static final int FLAG = -2;
  public static final int DOUBT = -2;
  public static final int EMPTY = -2;
  public static final int MINE = -2;
  private CellState state;


  public Cell(CellState state){
    this.state = state;
    this.state.setCell(this);
  }

  public int getValue(){
    return state.getValue();
  }
  public void incrementValue(){
    state.setValue(1);
  }

  public Cell (int x){  }

  public int getType() { return -4;}

  public void setType(int flag) {
  }

}
