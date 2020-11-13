import junit.framework.TestCase;
import org.junit.Before;

import java.util.Arrays;


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
    // this means every combination of rows*cols that's less than 1 should return -1
    board.setRows(5);
    board.setCols(5);
    board.createMines();
    assertEquals(8, board.getTotalMines());


    board.setRows(2);
    board.setCols(1);
    board.createMines();
    assertEquals(-1, board.getTotalMines());
  }

  public void testCreateMinesPosition(){
    board.setRows(5);
    board.setCols(5);
    board.createMines();
    int[] minesAssigment = board.getRandomMinesPosition();
    System.out.println(Arrays.toString(minesAssigment));
    assert minesAssigment.length == board.getTotalMines();

    board.setRows(1);
    board.setCols(2);
    board.createMines();
    minesAssigment = board.getRandomMinesPosition();
    System.out.println(Arrays.toString(minesAssigment));
    assert Arrays.equals(new int[]{-1}, minesAssigment);
  }


  public void testCreateAllCells(){
    board = new Board(5,5);
    board.setMinesPosition(new int[]{1,6,8,12,16,19,20,24});
    int[] expectedCells = new int[]{2, -1, 3, 1, 1, 2, -1, 3, -1, 1, 2, 3, -1, 3, 2, 2, -1, 2, 3, -1, -1, 2, 1, 2, -1};
    assert  (Arrays.equals(expectedCells, board.createAllCells()));
  }


  public void testGettingPositionAroundValues(){
    board.setCols(3);
    board.setRows(3);
    board.setMinesPosition(new int[]{1,2,3,4,5,6,7,8,9});

    assert Arrays.equals(new int[]{1,2,3,4,6,7,8,9}, board.getCellAround());



  }
}