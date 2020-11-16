package controller;

import model.Board;
import view.BoardView;


public class BoardController {
  BoardView view;
  Board model;
  TerminalScanner terminalScanner;


  public BoardController(BoardView view, Board model, TerminalScanner terminalScanner) {
    this.view = view;
    this.model = model;
    this.terminalScanner = terminalScanner;
  }

  public int askAction() {
    System.out.println("Actions to do:");
    System.out.println("[0] Open position");
    System.out.println("[1] Put flag");
    System.out.println("[2] Put question mark");
    return terminalScanner.readNumberFromTerminal(2);

  }
}



