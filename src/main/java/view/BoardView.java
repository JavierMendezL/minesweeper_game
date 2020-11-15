package view;

public class BoardView {
  int rows, cols;
  String[][] board;

  public void setUpView(int rows, int cols){
    this.rows = rows;
    this.cols = cols;
    board = new String[rows][cols];
    createBoard();
  }

  void createBoard(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = "[ ]";
      }
    }
  }
  public void drawBoard(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println("");
    }
  }

  public void drawInCell(int position, String input){
    int rows = position/this.cols;
    int cols = position%this.cols;
    board[rows][cols] = "["+input+"]";
  }
}