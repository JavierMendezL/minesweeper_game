public class Table {
  //min row i col 8
  //max rom=24 max col=32
  //max mines = 1/3(row*col)

  private final int row;
  private final int col;
  private final int mines;

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

  /*This method starts chain reaction. When user click on particular cell, if cell is empty (value = 0) this
    method look for other empty cells next to activated one. If finds one, it call checkCell in GridBox and in effect,
    start next scan on its closest area.
     */
  //public void isCellEmpty(){}


  //public void setTable(){}
  //public int getMineCells(){}
  //public void setCellValues(){}



}




