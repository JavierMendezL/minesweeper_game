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

  public void testSetStateToCell(){
    Cell cell = new Cell(Cell.MINE); //public i static
    assertEquals(-1, cell.getType()); //tipos de mina;

    cell.setType(Cell.NUMBER); //public static tipo numero
    assertEquals(1, cell.getType()); //tipo numero

    cell.setType(Cell.FLAG);
    assertEquals(2, cell.getType()); //Flag

    cell.setType(Cell.DOUBT);
    assertEquals(3, cell.getType()); //Interrogante - doubt

    cell.setType(Cell.EMPTY);
    assertEquals(0, cell.getType()); //vacio
  }

  //cell.getState(); //visible o invisible(notOpen)

}