import junit.framework.TestCase;
import org.junit.Test;

public class TableTest{
  @Test
  public void testSetSimpleGrid(){ //matriz cuadrara

    Table table = new Table(10, 10, 10);

    int numRows = table.getRow();
    int numCol = table.getCol();

    assert numRows == 10;
    assert numCol == 10;
  }
}