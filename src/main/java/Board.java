
public class Board {

  private int rows;
  private int cols;
  private int mines;

  public void setRows(int i) {
    this.rows = i;
    if (i<=0){
      this.rows = -1;
    }
  }

  public void setCols(int i) {
    this.cols = i;
    if (i<=0){
      this.cols = -1;
    }
  }

  public int getTotalCellNumber() {
    if (cols <= 0 || rows <= 0) return -1;
    return rows*cols;
  }

  public int getTotalMines() {
    return mines;
  }

  public void createMines() {
    mines = getTotalCellNumber()/3;
    if(getTotalCellNumber()/3 < 1){
      mines = -1;
    }
  }

  public int[] getMinesPosition() {
    return new int[]{1};
  }
}
