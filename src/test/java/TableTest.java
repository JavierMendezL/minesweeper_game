import junit.framework.TestCase;
import org.junit.Test;

public class TableTest extends TestCase{

  public void testSimpleAssignVariables(){

    Table table = new Table(10, 10, 10);

    int numRows = table.getRow();
    int numCol = table.getCol();

    assert numRows == 10;
    assert numCol == 10;
  }
  public void testValidateGrid(){ //assegurar que el row y el col no passen de sus rangos
    Table grid = new Table(7, 33, 10);
    assert !grid.isValidGrid();
  }

  public void testValidateMines(){
    Table grid = new Table (10, 10, 31);
    Table grid2 = new Table (8, 8, 21);
    assert !grid.isValidMines();
    assert !grid2.isValidMines();
  }

}