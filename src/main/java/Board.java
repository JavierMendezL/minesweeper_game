import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

  private int rows;
  private int cols;
  private int mines;

  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }
  public Board(){};

  public void setRows(int i) {
    this.rows = i;
    if (i <= 0) {
      this.rows = -1;
    }
  }

  public void setCols(int i) {
    this.cols = i;
    if (i <= 0) {
      this.cols = -1;
    }
  }

  public int getTotalCellNumber() {
    if (cols <= 0 || rows <= 0) return -1;
    return rows * cols;
  }

  public int getTotalMines() {
    return mines;
  }

  public void createMines() {
    mines = getTotalCellNumber() / 3;
    if (getTotalCellNumber() / 3 < 1) {
      mines = -1;
    }
  }

  public int[] getRandomMinesPosition() {
    try {
      int[] minesPosition = new int[getTotalMines()];
      int []allCells = new int[getTotalCellNumber()];
      List<Integer> integerList = new ArrayList<>();
      for (int i = 0; i < allCells.length; i++) {
        integerList.add(i);
      }
      Collections.shuffle(integerList);

      minesPosition =  integerList.stream().mapToInt(i-> i).toArray();
      return Arrays.copyOfRange(minesPosition, 0, getTotalMines());

    } catch (NegativeArraySizeException exception) {
      return new int[]{-1};
    }
  }

  public void setMinesPosition(int[] minesPosition) {
  }

  public int[] createAllCells() {
    int[] minesPositions = getRandomMinesPosition();

    for (int i = 0; i < minesPositions.length; i++) {


    }

    return new int[]{1};
  }

  public int[] getCellAround() {
    return new int[]{1};
  }
}
