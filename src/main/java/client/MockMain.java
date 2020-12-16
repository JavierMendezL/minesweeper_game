package client;

import controller.BoardController;
import controller.TerminalScanner;
import model.Board;
import model.RandomMinesGenerator;
import view.BoardView;
import model.Board;
import model.Cell;
import view.BoardView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MockMain {
	
	
	
	public static void main(String[] args) {
		
	    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
	    int actionToPerform;
	    actionToPerform = askAction(terminalScanner);
	    
	    
	    if(actionToPerform == 0) {
	    	
		BoardView boardView = new BoardView();
		Board board = new Board(3, 3);
		board.setGenerator(new RandomMinesGenerator());
		int[] aux = {3, 5};
		board.setMinesPosition(aux);
		board.setNumberMinesOnNeighbours();
			
		BoardController boardController = new BoardController(boardView, board, terminalScanner);
	    	
		int aux2 = (0 * board.getRows()) + 0;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (2 * board.getRows()) + 0;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (1 * board.getRows()) + 1;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (0 * board.getRows()) + 1;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (2 * board.getRows()) + 1;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (0 * board.getRows()) + 2;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (2 * board.getRows()) + 2;
		board.expandCell(aux2);
		boardView.setUpView(board.getRows(), board.getCols());
	    drawPlayingBoard(board, boardView);
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (1 * board.getRows()) + 0;
		board.expandCell(aux2);
		board.changeState(aux2, Cell.FLAG);
        boardView.drawInCell(aux2, "F");
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (1 * board.getRows()) + 0;
		board.expandCell(aux2);
		board.changeState(aux2, Cell.FLAG);
        boardView.drawInCell(aux2, "F");
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    aux2 = (1 * board.getRows()) + 2;
		board.expandCell(aux2);
		board.changeState(aux2, Cell.FLAG);
        boardView.drawInCell(aux2, "F");
	    boardView.drawBoard();
	    System.out.println("\n");
	    
	    if (board.isGameFinished()) {
	        System.out.println("You win the game :)");
	      }

	    }
	    
	    if(actionToPerform == 1)
	    {
	    	BoardView boardView = new BoardView();
			Board board = new Board(9, 9);
			board.setGenerator(new RandomMinesGenerator());
			int[] aux = {1, 6, 20, 4, 45};
			board.setMinesPosition(aux);
			board.setNumberMinesOnNeighbours();
				
			BoardController boardController = new BoardController(boardView, board, terminalScanner);
		    	
			int aux2 = (0 * board.getRows()) + 0;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (2 * board.getRows()) + 0;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (8 * board.getRows()) + 5;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 5;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (1 * board.getRows()) + 2;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 2;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 3;
			board.expandCell(aux2);
			boardView.setUpView(board.getRows(), board.getCols());
		    drawPlayingBoard(board, boardView);
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 1;
			board.expandCell(aux2);
			board.changeState(aux2, Cell.FLAG);
	        boardView.drawInCell(aux2, "F");
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 4;
			board.expandCell(aux2);
			board.changeState(aux2, Cell.FLAG);
	        boardView.drawInCell(aux2, "F");
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (5 * board.getRows()) + 0;
			board.expandCell(aux2);
			board.changeState(aux2, Cell.FLAG);
	        boardView.drawInCell(aux2, "F");
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (0 * board.getRows()) + 6;
			board.expandCell(aux2);
			board.changeState(aux2, Cell.FLAG);
	        boardView.drawInCell(aux2, "F");
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    aux2 = (2 * board.getRows()) + 2;
			board.expandCell(aux2);
			board.changeState(aux2, Cell.FLAG);
	        boardView.drawInCell(aux2, "F");
		    boardView.drawBoard();
		    System.out.println("\n");
		    
		    if (board.isGameFinished()) {
		        System.out.println("You win the game :)");
		      }
	    }
	}
	
	
	
	public static void drawPlayingBoard(Board b, BoardView v) {
	    for (int i = 0; i < b.getTotalCellNumber(); i++) {
	      if (b.getCells()[i].isVisible()) {
	        if (b.getCells()[i].getValue() == Cell.MINE) {
	          v.drawInCell(i, "*");
	        }
	        if (b.getCells()[i].getType() == Cell.NO_MINE) {
	          v.drawInCell(i, String.valueOf(b.getCells()[i].getValue()));
	        }
	        if (b.getCells()[i].getType() == Cell.EMPTY) {
	          v.drawInCell(i, "0");
	        }
	      }
	    }
	  }
	
	  public static int askAction(TerminalScanner s) {
		    System.out.println("Indique el número de la partida a reproducir: ");
		    return s.readNumberFromTerminal(1);
		  }
}
