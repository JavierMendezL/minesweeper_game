import junit.framework.TestCase;

public class BoardTest extends TestCase {
  Board board;
  public void setUp() throws Exception {
    super.setUp();
    board = new Board();
  }

  public void testAssignRowsColsToBoard(){

    board.setRows(5);
    board.setCols(5);
    int totalCellNumber = board.getTotalCellNumber();
    assertEquals(25, totalCellNumber);

  }
}