package client;

import controller.BoardController;
import model.Board;
import view.BoardView;

public class Main {
  public static void main(String[] args) {

    BoardView boardView = new BoardView();
    Board board = new Board(10, 10);
    board.createMines();
    board.getRandomMinesPosition();

    BoardController boardController = new BoardController(boardView, board);
    boardController.setUpController();

  }
}
