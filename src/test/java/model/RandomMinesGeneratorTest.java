package model;

import junit.framework.TestCase;

public class RandomMinesGeneratorTest extends TestCase {

    public void testSizeGeneratedArray(){
        int[] expected = RandomMinesGenerator.generate(10, 8, 3);
        assertEquals(3, expected.length);
    }

    public void testPassedNegativeValueReturnsArrayWithMinusOne(){
        int[] expected = RandomMinesGenerator.generate(10, 8, -1);
        assertEquals(new int[]{-1}, expected);
    }

}