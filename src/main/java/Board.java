import java.security.InvalidParameterException;

public class Board {

  private int rows;
  private int cols;

  public Board(int rows, int cols) {


  }


  public void setRows(int i) {
    this.rows = i;
  }

  public void setCols(int i) {
    assert i>=0;
    this.cols = i;
  }

  public int getTotalCellNumber() {
    return rows*cols;
  }
}
