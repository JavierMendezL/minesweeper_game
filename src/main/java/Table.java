public class Table {
  //min row i col 8
  //max rom=24 max col=32
  //max mines = 1/3(row*col)

  private int row;
  private int col;
  private int mines;

  public Table(int row, int col, int mines) {
    this.row = row;
    this.col = col;
    this.mines = mines;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public int getMines() {
    return mines;
  }

  public boolean isValidGrid() {
    return (row >= 8 && row <= 24) || (col >= 8 && col <= 32);
  }

  public boolean isValidMines() {
    int result = row * col / 3;
    return mines < 1 || mines >= result;
  }

//getMinecells
}




