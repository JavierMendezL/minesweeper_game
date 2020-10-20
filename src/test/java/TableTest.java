import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class TableTest extends TestCase {

  public void testSimpleAssignVariables() {

    Table table = new Table(10, 10, 10);

    int numRows = table.getRow();
    int numCol = table.getCol();

    assert numRows == 10;
    assert numCol == 10;
  }

  public void testValidateGrid() { //assegurar que el row y el col no passen de sus rangos
    Table grid = new Table(7, 33, 10);
    assert !grid.isValidGrid();
  }

  public void testValidateMines() {
    Table grid = new Table(10, 10, 33);
    Table grid2 = new Table(8, 8, 21);
    assertEquals(33, grid.getMines());
    assertEquals(21, grid2.getMines());
    assert grid.isValidMines();
    assert grid2.isValidMines();
  }

  public void testAssignMinesInGrid() { //TODO: mock
    int min = 0;
    int max = 64 - 1;
    int mines = 10;
    int count = 0;

    Integer[] arr = new Integer[8 * 8];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    int[] ListofMines = new int[mines];
    Collections.shuffle(Arrays.asList(arr));
    for (int j = 0; j < mines; j++) {
      ListofMines[j] = arr[j];
    }
    System.out.println(Arrays.toString(ListofMines)); //TODO: borrar sout
  }

}