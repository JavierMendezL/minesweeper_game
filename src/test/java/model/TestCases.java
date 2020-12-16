package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Before;

import controller.BoardController;
import controller.TerminalScanner;
import junit.framework.TestCase;
import view.BoardView;

public class TestCases extends TestCase {
	  @Before
	  public void setUp() { }
	  
	  public void testCaseStep_1() {  
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    board.setMinesPosition(board.getRandomMinesPosition());
		    board.setNumberMinesOnNeighbours();

		    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
		    int aux;

		    for(int i= 0; i <= 2; i++)
		    	for(int j = 0; j <= 2; j++ )
		    	{
		    		aux = i * 3 + j;
		    		board.changeState(aux, Cell.FLAG);
		    	}
		    boolean check = false;
		    check = board.isGameFinished(); 
		    assert check == true;    
	  }
	  
	  public void testCaseStep_2() {  
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(8);
		    board.setMinesPosition(board.getRandomMinesPosition());
		    board.setNumberMinesOnNeighbours();

		    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
		    int aux;

		    for(int i= 0; i <= 2; i++)
		    	for(int j = 0; j <= 2; j++ )
		    	{
		    		aux = i * 3 + j;
		    		board.changeState(aux, Cell.FLAG);
		    	}
		    boolean check = true;
		    check = board.isGameFinished(); 
		    assert check == false;    
	  }
	  
	  public void testCaseStep_3() {  
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    board.setMinesPosition(board.getRandomMinesPosition());
		    board.setNumberMinesOnNeighbours();

		    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
		    int aux;
		    
		    aux = 1 * 3 + 1;
		    board.expandCell(aux);

		    boolean check = false;
		    check = board.isGameOver();
		    assert check == true;    
	  }
	  
	  public void testCaseStep_4() {  
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    board.setMinesPosition(board.getRandomMinesPosition());
		    board.setNumberMinesOnNeighbours();

		    TerminalScanner terminalScanner = new TerminalScanner(new BufferedReader(new InputStreamReader(System.in)));
		    int aux;

		    for(int i= 0; i <= 2; i++)
		    	for(int j = 0; j <= 2; j++ )
		    	{
		    		aux = i * 3 + j;
		    		board.changeState(aux, Cell.DOUBT);
		    	}
		    boolean check = true;
		    check = board.isGameFinished(); 
		    assert check == false;    
	  }
	  
	  public void testCaseStep_5() {  
		  	//3 Mines in the square corner
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    int[] t = {1,3,4,5,7};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    Cell cells[] = board.getCells();
		    assertEquals(3, cells[0].getValue());
		    assertEquals(3, cells[2].getValue());
		    assertEquals(3, cells[6].getValue());
		    assertEquals(3, cells[8].getValue());
		    
		    //2 Mines in the square corner
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {1,3,5,7};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(2, cells[0].getValue());
		    assertEquals(2, cells[2].getValue());
		    assertEquals(2, cells[6].getValue());
		    assertEquals(2, cells[8].getValue());
		    
		    //1 Mine in the square corner
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {1, 7};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(1, cells[0].getValue());
		    assertEquals(1, cells[2].getValue());
		    assertEquals(1, cells[6].getValue());
		    assertEquals(1, cells[8].getValue());
		    
		    //0 Mines in the square corner
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(0, cells[0].getValue());
		    assertEquals(0, cells[2].getValue());
		    assertEquals(0, cells[6].getValue());
		    assertEquals(0, cells[8].getValue());
	  }
	  
	  public void testCaseStep_6() {  
		  	//5 Mines in the square border up an down
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    int[] t = {0,2,3,4,5,6,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    Cell cells[] = board.getCells();
		    assertEquals(5, cells[1].getValue());
		    assertEquals(5, cells[7].getValue());
		    
		    //5 Mines in the square border left and right
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {0,1,2,4,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(5, cells[3].getValue());
		    assertEquals(5, cells[5].getValue());
		    
		  	//4 Mines in the square border up an down
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {0,2,4,5,6,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(4, cells[1].getValue());
		    assertEquals(4, cells[7].getValue());
		    
		    //4 Mines in the square border left and right
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {0,2,4,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(4, cells[3].getValue());
		    assertEquals(4, cells[5].getValue());
		    
		    
		  	//3 Mines in the square border up an down
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {0,2,5,6,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(3, cells[1].getValue());
		    assertEquals(3, cells[7].getValue());
		    
		    //3 Mines in the square border left and right
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {0,2,4,7};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(3, cells[3].getValue());
		    assertEquals(3, cells[5].getValue());
		    
		  	//2 Mines in the square border up an down
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {2,5,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(2, cells[1].getValue());
		    assertEquals(2, cells[7].getValue());
		    
		    //2 Mines in the square border left and right
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {4,7};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(2, cells[3].getValue());
		    assertEquals(2, cells[5].getValue());
		    
		  	//1 Mines in the square border up an down
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {2,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(1, cells[1].getValue());
		    assertEquals(1, cells[7].getValue());
		    
		    //1 Mines in the square border left and right
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {4};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(1, cells[3].getValue());
		    assertEquals(1, cells[5].getValue());
		    
		  //0 Mines in the square border all borders
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(0, cells[3].getValue());
		    assertEquals(0, cells[5].getValue());
		    assertEquals(0, cells[1].getValue());
		    assertEquals(0, cells[7].getValue());    
	  }
	  
	  public void testCaseStep_7() {  
		  	///8 Mines///
		    BoardView boardView = new BoardView();
		    Board board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    int[] t = {0,1,2,3,5,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    Cell cells[] = board.getCells();
		    assertEquals(8, cells[4].getValue());
		    
		    ///7 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {1,2,3,5,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(7, cells[4].getValue());
		    
		    ///6 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {2,3,5,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(6, cells[4].getValue());
		    
		    ///5 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {3,5,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(5, cells[4].getValue());
		    ///4 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {5,6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(4, cells[4].getValue());
		    
		    ///3 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {6,7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(3, cells[4].getValue());
		    
		    ///2 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {7,8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(2, cells[4].getValue());
		  ///7 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {8};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(1, cells[4].getValue());
		    
		    ///0 Mines////
		    board = new Board(3, 3);
		    board.setGenerator(new RandomMinesGenerator());
		    board.createMines(9);
		    t = new int[] {};
		    board.setMinesPosition(t);
		    board.getCells();
		    board.setNumberMinesOnNeighbours();

		    cells = board.getCells();
		    assertEquals(0, cells[4].getValue());
		    

	  }
}
