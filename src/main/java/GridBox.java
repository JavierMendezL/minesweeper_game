import javafx.scene.control.Cell;

import javax.swing.*;                   //for color
import java.awt.*;                      //for JButtom
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GridBox implements ActionListener {
  private final boolean notChecked;
  private JButton button;
  private int value;
  private final int sideOfCell = 8;
  private final int limit = sideOfCell-2;

  public GridBox() { notChecked=true;}
  public boolean isNotChecked() { return notChecked;}
  public boolean isEmpty() { return isNotChecked() && value==0;}

/*
  public void displayValue(){
        if(value==-1){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
  }
  public void checkCell(){
    button.setEnabled(false);
    displayValue();
    notChecked = false;
    if(value == 0) Table.isCellEmpty();
    if(value == -1) Table.fail();
  }

*/
  @Override
  public void actionPerformed(ActionEvent e) {
    //checkCell();
  }

}