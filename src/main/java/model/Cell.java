package model;

public class Cell{
  public static final int MINE = -1;
  public static final int EMPTY = 0;
  public static final int NUMBER = 1;
  public static final int FLAG = 2;
  public static final int DOUBT = 3;

  private CellState state;

  private int type;
  private boolean visible;
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

  public Cell (int x){ this.type=x; }

  public int getType() { return type;}

  public void setType(int type) { this.type=type; }

  public boolean isVisible() { return visible; }

  public void setVisible(boolean b) {this.visible=b; }

}
