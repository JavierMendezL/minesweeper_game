public class Board {

  private int rows;
  private int cols;

  public void setRows(int i) {
    this.rows = i;
  }

  public void setCols(int i) {
    this.cols = i;
  }

  public int getTotalCellNumber() {
    return rows*cols;
  }
}
