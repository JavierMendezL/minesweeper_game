public class Table {
  //min row i col 8
  //max rom=24 max col=32
  //max mines = 1/3(row*col)

  private int row;
  private int col;

  public Table(int row, int col, int mines){
    this.row=row;
    this.col=col;
  }

  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }

  public boolean isValid(){
    return true;
  }


}
