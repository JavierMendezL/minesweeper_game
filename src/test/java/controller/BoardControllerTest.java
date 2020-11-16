package controller;

import junit.framework.TestCase;
import model.Board;
import view.BoardView;

public class BoardControllerTest extends TestCase {

  public void testVerifyMultipleActionControllerCanDo(){
    Board model = new Board(10,10);
    model.createMines(7);
    model.setMinesPosition(model.getRandomMinesPosition());

    BoardView view = new BoardView();
    BoardController boardController = new BoardController(view, model);

    int option = boardController.askAction(); //OPEN
    assertEquals(1, option);
    option = boardController.askAction(); //DOUBT
    assertEquals(2, option);
    option = boardController.askAction(); //FLAG
    assertEquals(3, option);

  }

}