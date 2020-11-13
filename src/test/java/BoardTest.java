import junit.framework.TestCase;
import org.junit.Before;

public class BoardTest extends TestCase{
  Board board;
  @Before
  public void setUp(){
    board = new Board();
  }


  public void testAssignRowsColsToBoard(){
    board.setRows(5);
    board.setCols(5);
    int totalCellNumber = board.getTotalCellNumber();
    assertEquals(25, totalCellNumber);

  }

  public void testAssignRowsColsToBoardFails(){
    //-1 for error.
    //Test with negative, null or zero cols/rows
    Board testBoard= new Board();

    testBoard.setCols(0);
    assertEquals(-1, testBoard.getTotalCellNumber());

    testBoard.setRows(4);
    assertEquals(-1, testBoard.getTotalCellNumber());

    testBoard.setCols(5);
    testBoard.setRows(-1);
    assertEquals(-1, testBoard.getTotalCellNumber());

    testBoard.setCols(0);
    testBoard.setRows(0);
    assertEquals(-1, testBoard.getTotalCellNumber());

    testBoard.setCols(1);
    testBoard.setRows(1);
    assertEquals(1, testBoard.getTotalCellNumber());

  }

  public void testTotalMineNumber(){
    //Mines ratio should be (cols*row)/3
    // this means every combination of rows*cols that's less than 3 should return -1
    board.setRows(5);
    board.setCols(5);
    board.createMines();
    assertEquals(8, board.getTotalMines());
  }




}