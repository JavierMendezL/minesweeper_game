
public class Board {

  private int rows;
  private int cols;

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
    return 0;
  }

  public void createMines() {

  }
}
