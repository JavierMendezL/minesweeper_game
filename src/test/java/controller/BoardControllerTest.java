package controller;

import junit.framework.TestCase;
import model.Board;
import model.MockGenerate;
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
    model = new Board(3,3);
    model.setGenerator(new MockGenerate());
    model.createMines(2);
    model.setMinesPosition(model.getRandomMinesPosition());

    view = new BoardView();
    boardController = new BoardController(view, model, terminalScanner);

  }

  public void testVerifyMultipleActionControllerCanDo(){
    int option = boardController.askAction(); //OPEN
    assertEquals(2, option);
  }

  public void testGameFlow(){
    BoardView boardView = new BoardView();
    MockScanner mockScanner = new MockScanner(new InputStreamReader(System.in), true);
    TerminalScanner terminalScanner = new TerminalScanner(mockScanner);
    BoardController boardController = new BoardController(boardView, model, terminalScanner);

    boardController.startGame();

  }


}