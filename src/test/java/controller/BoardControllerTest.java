package controller;

import junit.framework.TestCase;
import model.Board;
import org.junit.Before;
import view.BoardView;

import java.io.InputStreamReader;

public class BoardControllerTest extends TestCase {
  TerminalScanner terminalScanner;
  @Before
  public void setUp() {
    MockScanner mockScanner = new MockScanner(new InputStreamReader(System.in));
    terminalScanner = new TerminalScanner(mockScanner);
  }

  public void testVerifyMultipleActionControllerCanDo(){
    Board model = new Board(10,10);
    model.createMines(7);
    model.setMinesPosition(model.getRandomMinesPosition());

    BoardView view = new BoardView();
    BoardController boardController = new BoardController(view, model, terminalScanner);

    int option = boardController.askAction(); //OPEN
    assertEquals(2, option);

  }

}