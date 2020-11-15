package controller;

import model.Board;
import view.BoardView;


public class BoardController {
  BoardView view;
  Board model;

  public BoardController(BoardView view, Board model) {
    this.view = view;
    this.model = model;
  }
}



