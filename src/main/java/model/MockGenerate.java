package model;

public class MockGenerate implements IRandomMinesGenerator{

  public MockGenerate(){  }

  @Override
  public int[] generate(int rows, int cols, int mines) {
    return new int[]{3, 2, 1};
  }


}
