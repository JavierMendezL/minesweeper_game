package model;

import junit.framework.TestCase;
import org.junit.Before;

public class CellTest extends TestCase {
  @Before
  public void setUp() {  }

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

  public void testCheckCellVisibility(){
    Cell cell = new Cell(Cell.MINE);
    assert !cell.isVisible();
    cell.setVisible(true);
    assert cell.isVisible();

  }

  public void testIncrementValueOfCell(){
    Cell cell = new Cell(Cell.NUMBER);
    cell.incrementValue();
    int result = cell.getValue();
    assertEquals(1, result);

    cell = new Cell(Cell.MINE);
    cell.incrementValue();
    result = cell.getValue();
    assertEquals(-1, result);
  }




  //cell.getState(); //visible o invisible(notOpen)


}