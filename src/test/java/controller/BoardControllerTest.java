package controller;

import junit.framework.TestCase;
import model.Cell;

public class BoardControllerTest extends TestCase {
  BoardController boardController;
  MockBoard mockBoard;
  MockView mockView;

  public void setUp() throws Exception {
    super.setUp();
    mockBoard = new MockBoard();
    mockView = new MockView();
    boardController = new BoardController(mockView, mockBoard);

  }

  public void testWhenCellIsPressedMakeItVisible() {
    boardController.cellPressed(10);
    assert mockBoard.getCells()[10].isVisible();
  }

  public void testSetCellWithFlag(){
    boardController.rightClickOn(10);
    assertEquals(Cell.FLAG, mockBoard.getCells()[10].getState());
    boardController.rightClickOn(11);
    assertEquals(Cell.DOUBT, mockBoard.getCells()[11].getState());
    boardController.rightClickOn(12);
    assertEquals(Cell.EMPTY, mockBoard.getCells()[12].getState());
  }
}