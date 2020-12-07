package client;

import controller.BoardController;
import controller.TerminalScanner;
import model.Board;
import model.RandomMinesGenerator;
import view.BoardView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {

    BoardView boardView = new BoardView();
    Board board = new Board(3, 3);
    board.setGenerator(new RandomMinesGenerator());
    board.createMines(2);
    board.setMinesPosition(board.getRandomMinesPosition());
    board.setNumberMinesOnNeighbours();

    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
    BoardController boardController = new BoardController(boardView, board, terminalScanner);

    boardController.startGame();


  }
}
