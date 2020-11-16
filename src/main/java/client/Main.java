package client;

import controller.TerminalScanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {

    /*BoardView boardView = new BoardView();
    Board board = new Board(10, 10);
    board.createMines(20);
    board.setMinesPosition(board.getRandomMinesPosition());
    board.setNumberMinesOnNeighbours();


    BoardController boardController = new BoardController(boardView, board);
    //boardController.setUpController();*/
    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));

    terminalScanner.readNumberFromTerminal(10);

  }
}
