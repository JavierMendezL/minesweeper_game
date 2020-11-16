package model;

import junit.framework.TestCase;
import org.junit.Before;

public class CellTest extends TestCase {
  @Before
  public void setUp() {  }

  public void testSetStateToCell(){
    Cell cell = new Cell(Cell.MINE); //public i static
    assertEquals(-1, cell.getType()); //tipos de mina;
    cell.setState(Cell.FLAG);
    assertEquals(2, cell.getState()); //Flag
    cell.setState(Cell.DOUBT);
    assertEquals(3, cell.getState()); //Flag
    cell.setState(Cell.EMPTY);
    assertEquals(0, cell.getState()); //Flag

    cell.setType(Cell.NO_MINE); //public static tipo numero
    assertEquals(1, cell.getType()); //tipo numero
    cell.setState(Cell.FLAG);
    assertEquals(2, cell.getState()); //Flag
    cell.setState(Cell.DOUBT);
    assertEquals(3, cell.getState()); //Flag
    cell.setState(Cell.EMPTY);
    assertEquals(0, cell.getState()); //Flag

  }

  public void testCheckCellVisibility(){
    Cell cell = new Cell(Cell.MINE);
    assert !cell.isVisible();
    cell.setVisible(true);
    assert cell.isVisible();

  }

  public void testIncrementValueOfCell(){
    Cell cell = new Cell(Cell.NO_MINE);
    cell.incrementValue();
    int result = cell.getValue();
    assertEquals(1, result);

    cell = new Cell(Cell.MINE);
    cell.incrementValue();
    result = cell.getValue();
    assertEquals(-1, result);
  }


}