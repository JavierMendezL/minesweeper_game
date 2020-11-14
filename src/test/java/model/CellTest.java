package model;

import junit.framework.TestCase;
import org.junit.Before;

public class CellTest extends TestCase {
  Cell cell;
  @Before
  public void setUp() {
    CellState stateNumber = new MockNumber();
    cell = new Cell(stateNumber);
  }

  public void testIncrementValue(){
    cell.incrementValue();
    assertEquals(4, cell.getValue());
  }

  public void testCheckMineValue(){
    CellState stateMines = new MockMines();
    cell = new Cell(stateMines);
    cell.getValue();
    assertEquals(-1, cell.getValue());
  }

}