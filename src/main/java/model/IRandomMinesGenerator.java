package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface IRandomMinesGenerator {

  int[] generate(int rows, int cols, int mines);

}
