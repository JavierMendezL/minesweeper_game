package controller;

import junit.framework.TestCase;
import model.Board;
import org.junit.Before;
import view.BoardView;

import java.io.InputStreamReader;

public class BoardControllerTest extends TestCase {
  TerminalScanner terminalScanner;
  BoardController boardController;
  Board model;
  BoardView view;
  @Before
  public void setUp() {
    MockScanner mockScanner = new MockScanner(new InputStreamReader(System.in));
    terminalScanner = new TerminalScanner(mockScanner);
    model = new Board(10,10);
    model.createMines(7);
    model.setMinesPosition(model.getRandomMinesPosition());

    view = new BoardView();
    boardController = new BoardController(view, model, terminalScanner);

  }

  public void testVerifyMultipleActionControllerCanDo(){

    int option = boardController.askAction(); //OPEN
    assertEquals(2, option);

  }



  /*public void testPerformActionWithController(){

    //boardController.performeAction(2); //PUT QUESTION-MARK on CELL 7X3 (mockScanner)
  }*/

}