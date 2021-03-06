package model;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.Arrays;


public class BoardTest extends TestCase {
  Board board;

  @Before
  public void setUp() {
    board = new Board();
  }


  public void testAssignRowsColsToBoard() {
    board.setRows(5);
    board.setCols(5);
    int totalCellNumber = board.getTotalCellNumber();
    assertEquals(25, totalCellNumber);

    board.setRows(6);
    board.setCols(4);
    int totalCellNumber1 = board.getTotalCellNumber();
    assertEquals(24, totalCellNumber1);

    board.setRows(7);
    board.setCols(1);
    int totalCellNumber2 = board.getTotalCellNumber();
    assertEquals(7, totalCellNumber2);

    board.setRows(1);
    board.setCols(3);
    int totalCellNumber3 = board.getTotalCellNumber();
    assertEquals(3, totalCellNumber3);

    board.setRows(1);
    board.setCols(1);
    int totalCellNumber4 = board.getTotalCellNumber();
    assertEquals(1, totalCellNumber4);

  }

  public void testAssignRowsColsToBoardFails() {
    //-1 for error.
    //Test with negative, null or zero cols/rows
    Board testBoard = new Board();

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

  public void testTotalMineNumber() {
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

    board.setRows(1);
    board.setCols(3);
    board.createMines();
    assertEquals(1, board.getTotalMines());

    board.setRows(0);
    board.setCols(3);
    board.createMines();
    assertEquals(-1, board.getTotalMines());

    board.setRows(0);
    board.setCols(0);
    board.createMines();
    assertEquals(-1, board.getTotalMines());
  }

  public void testCreateMinesPosition() {
    MockGenerate mock = new MockGenerate();
    board.setGenerator(mock);

    board.setRows(5);
    board.setCols(5);
    board.createMines();
    int[] minesAssigment = board.getRandomMinesPosition();
    //assert minesAssigment.length == board.getTotalMines();
    assert Arrays.equals(new int[]{3, 2, 1}, minesAssigment);

  }



  public void testCreateAllCells() {
    board = new Board(5, 5);
    board.setMinesPosition(new int[]{1, 6, 8, 12, 16, 19, 20, 24});
    int[] results = board.setNumberMinesOnNeighbours();
    assert Arrays.equals(new int[]{2, -1, 3, 1, 1, 2, -1, 4, -1, 1, 2, 3, -1, 3, 2, 2, -1, 2, 3, -1, -1, 2, 1, 2, -1}, results);

    board = new Board(6, 4);
    board.setMinesPosition(new int[]{0, 3, 5, 10, 12, 15, 18, 21});
    int[] results1 = board.setNumberMinesOnNeighbours();
    assert Arrays.equals(new int[]{-1, 2, 2, -1, 2, -1, 3, 2, 2, 3, -1, 2, -1, 3, 3, -1, 2, 3, -1, 2, 1, -1, 2, 1}, results1);

    board = new Board(5, 4);
    board.setMinesPosition(new int[]{0, 2, 5, 7, 8});
    int[] results2 = board.setNumberMinesOnNeighbours();
    assert Arrays.equals(new int[]{-1, 3, -1, 2, 3, -1, 3, -1, -1, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0}, results2);

  }


  public void testGettingPositionAroundValues() {
    board.setCols(3);
    board.setRows(3);
    int[] result = board.getCellAroundPosition(4);
    assert Arrays.equals(new int[]{0, 1, 2, 3, 5, 6, 7, 8}, result);

    board.setCols(3);
    board.setRows(4);
    int[] result1 = board.getCellAroundPosition(0);
    assert Arrays.equals(new int[]{-4, -3, -2, -1, 1, 2, 3, 4}, result1);

    board.setCols(3);
    board.setRows(4);
    int[] result2 = board.getCellAroundPosition(10);
    assert Arrays.equals(new int[]{6, 7, 8, 9, 11, 12, 13, 14}, result2);

  }

  public void testCreatingCustomMineNumber() {
    Board board = new Board(10, 10);
    board.createMines(10);
    int results = board.getTotalMines();
    assertEquals(10, results);

    board.createMines(-4);
    results = board.getTotalMines();
    assertEquals(-1, results);

    board.createMines(0);
    results = board.getTotalMines();
    assertEquals(-1, results);
  }

  public void testCheckIfSurroundingValuesAreCorrect() {
    //{topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight}
    //{0      ,1   , 2       , 3   , 4    , 5         , 6     , 7          }
    //{0, 1, 2, 3, 4, 5, 6, 7}
    Board board = new Board(9, 9);

    int[] positionsThatCanBeModified = board.getSurroundingPositions(0); //0 is top-left : {4,6,7} -->valid in 9x9 board

    assert Arrays.equals(new int[]{-1, -1, -1, -1, 1, -1, 9, 10}, positionsThatCanBeModified);

    board = new Board(3, 5);
    positionsThatCanBeModified = board.getSurroundingPositions(4);
    assert Arrays.equals(new int[]{-1, -1, -1, 3, -1, 8, 9, -1}, positionsThatCanBeModified);

    positionsThatCanBeModified = board.getSurroundingPositions(7);
    assert Arrays.equals(new int[]{1, 2, 3, 6, 8, 11, 12, 13}, positionsThatCanBeModified);
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Testing 9 positions from 1 board
    board = new Board(6, 4);

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

    board = new Board(3, 5);
    positionsThatCanBeModified = board.getSurroundingPositions(4);
    assert Arrays.equals(new int[]{-1, -1, -1, 3, -1, 8, 9, -1}, positionsThatCanBeModified);

  }


  public void testExpandCell() {
    board = new Board(8, 8);
    board.setMinesPosition(new int[]{1, 6, 8, 12, 16, 19, 20, 24});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard = board.expandCell(22);
    assert Arrays.equals(new boolean[]{
        false, false, false, false, false, false, false, false,
        false, false, false, false, false, true, true, true,
        false, false, false, false, false, true, true, true,
        false, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true}, expandedBoard);


    board = new Board(6, 4);
    board.setMinesPosition(new int[]{6, 9, 16});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard1 = board.expandCell(18);
    assert Arrays.equals(new boolean[]{
        false, false, false, false,
        false, false, false, false,
        false, false, true, true,
        false, true, true, true,
        false, true, true, true,
        false, true, true, true}, expandedBoard1);

    board = new Board(6, 4);
    board.setMinesPosition(new int[]{1, 4, 5});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard2 = board.expandCell(0);
    assert Arrays.equals(new boolean[]{                        //pone todos false
        true, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false}, expandedBoard2);

    board = new Board(6, 4);
    board.setMinesPosition(new int[]{2, 6, 8, 9});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard3 = board.expandCell(5);

    assert Arrays.equals(new boolean[]{
        false, false, false, false,
        false, true, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false}, expandedBoard3);

    board = new Board(6, 4);
    board.setMinesPosition(new int[]{13, 20, 21, 22, 23});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard4 = board.expandCell(17);

    assert Arrays.equals(new boolean[]{
        false, false, false, false,                          //Pone pos 8-9-10 a false, pero
        false, false, false, false,                          // IMPORTANTE pone la 17 a false cuando es la que hemos clicado
        false, false, false, false,
        false, false, false, false,
        false, true, false, false,
        false, false, false, false}, expandedBoard4);

    board = new Board(3, 3);
    board.setMinesPosition(new int[]{0, 4, 5});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard5 = board.expandCell(8); //Pone el 8 a false (es el que hemos clicado)
    assert Arrays.equals(new boolean[]{
        false, false, false,
        false, false, false,
        false, false, true}, expandedBoard5);

    board = new Board(5, 5);
    board.setMinesPosition(new int[]{20});
    board.setNumberMinesOnNeighbours();
    boolean[] expandedBoard6 = board.expandCell(4);
    assert Arrays.equals(new boolean[]{
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        false, true, true, true, true}, expandedBoard6);
  }

  public void testCheckIfGameIsOver(){
    board = new Board(10,10);
    board.createMines(2);
    board.setMinesPosition(new int[]{1,3});
    board.setNumberMinesOnNeighbours();

    board.expandCell(1);

    boolean gameStatus = board.isGameOver();

    Cell[] cells = board.getCells();

    assert cells[1].getType() == Cell.MINE;
    assert cells[1].isVisible();
    assert gameStatus;

  }

  public void testCheckIfGameIsFinished(){
    board = new Board(3,3);
    board.createMines(2);
    board.setMinesPosition(new int[]{1,3});
    board.setNumberMinesOnNeighbours();
    board.expandCell(8);
    board.expandCell(0);
    board.expandCell(2);
    boolean gameIsFinished = board.isGameFinished();
    assert !gameIsFinished;
    board.expandCell(6);
    gameIsFinished = board.isGameFinished();
    assert !gameIsFinished;


    board.changeState(1,Cell.FLAG);

    board.changeState(3,Cell.FLAG);

    gameIsFinished = board.isGameFinished();
    assert gameIsFinished;

  }



}