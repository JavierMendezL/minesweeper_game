package model;

public class Cell {
  public static final int MINE = -1;
  public static final int EMPTY = 0;
  public static final int NO_MINE = 1;
  public static final int FLAG = 2;
    public static final int DOUBT = 3;


  private int type;
  private boolean visible;
  private int value;
  private int state;

  public Cell(int type) {
    this.type = type;
    if (type == MINE){
      value = -1;
    }else {
      value = 0;
    }
    state = EMPTY;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getValue() {
    return value;
  }

  public void incrementValue() {
    if (type == NO_MINE) {
      value += 1;
    }else if(type == EMPTY){
      this.setType(NO_MINE);
      value += 1;
    }
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean b) {
    this.visible = b;
  }

}
