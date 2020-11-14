package model;

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
    //int[] expectedCells = new int[]{2, -1, 3, 1, 1, 2, -1, 3, -1, 1, 2, 3, -1, 3, 2, 2, -1, 2, 3, -1, -1, 2, 1, 2, -1};
    int[] results = board.setNumberMinesOnNeighbours();
    assert  Arrays.equals(new int[]{2, -1, 3, 1, 1, 2, -1, 4, -1, 1, 2, 3, -1, 3, 2, 2, -1, 2, 3, -1, -1, 2, 1, 2, -1}, results);
  }


  public void testGettingPositionAroundValues(){
    board.setCols(3);
    board.setRows(3);
    int [] result = board.getCellAroundPosition(4);
    assert Arrays.equals(new int[]{0,1,2,3,5,6,7,8}, result);

  }

  public void testCreatingCustomMineNumber(){
    Board board = new Board(10, 10);
    board.createMines(10);
    int results = board.getTotalMines();
    assertEquals(10,results);


    board.createMines(-4);
    results = board.getTotalMines();
    assertEquals(-1,results);

    board.createMines(0);
    results = board.getTotalMines();
    assertEquals(-1,results);
  }

  public void testCheckIfSurroundingValuesAreCorrect(){
    //{topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight}
    //{0      ,1   , 2       , 3   , 4    , 5         , 6     , 7          }
    //{0, 1, 2, 3, 4, 5, 6, 7}
    Board board = new Board(9, 9);

    int [] positionsThatCanBeModified = board.getSurroundingPositions(0); //0 is top-left : {4,6,7} -->valid in 9x9 board

    assert Arrays.equals(new int[]{-1, -1, -1, -1 ,1, -1, 9, 10}, positionsThatCanBeModified);

    board = new Board(3,5);
    positionsThatCanBeModified = board.getSurroundingPositions(4);
    assert Arrays.equals(new int[]{-1, -1, -1, 3, -1, 8, 9, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(7);
    assert Arrays.equals(new int[]{1, 2, 3, 6, 8, 11, 12, 13}, positionsThatCanBeModified);
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Testing 9 positions from 1 board
    board = new Board (6,4);

    positionsThatCanBeModified = board.getSurroundingPositions(0); //topLeft
    assert Arrays.equals(new int[]{-1, -1, -1, -1, 1, -1, 4, 5}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(1); //top
    assert Arrays.equals(new int[]{-1, -1, -1, 0, 2, 4, 5, 6}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(3); //topRight
    assert Arrays.equals(new int[]{-1, -1, -1, 2, -1, 6, 7, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(4); //Left
    assert Arrays.equals(new int[]{-1, 0, 1, -1, 5, -1, 8, 9}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(9); //Center
    assert Arrays.equals(new int[]{4, 5, 6, 8, 10, 12, 13, 14}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(15); //Right
    assert Arrays.equals(new int[]{10, 11, -1, 14, -1, 18, 19, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(20); //bottomLeft
    assert Arrays.equals(new int[]{-1, 16, 17, -1, 21, -1, -1, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(22); //bottom
    assert Arrays.equals(new int[]{17, 18, 19, 21, 23, -1, -1, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(23); //bottomRight
    assert Arrays.equals(new int[]{18, 19, -1, 22, -1, -1, -1, -1}, positionsThatCanBeModified);

  }


}