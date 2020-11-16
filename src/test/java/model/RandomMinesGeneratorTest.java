package model;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RandomMinesGeneratorTest extends TestCase {

    public void testSizeGeneratedArray(){
        int[] expected = RandomMinesGenerator.generate(10, 8, 3);
        assertEquals(3, expected.length);
    }

    public void testPassedNegativeValueReturnsArrayWithMinusOne(){
        int[] expected = RandomMinesGenerator.generate(10, 8, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(-1, 8, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(2, -1, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(-1, -1, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(2, -1, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(-1, 1, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = RandomMinesGenerator.generate(-1, -1, -1);
        assert Arrays.equals(new int[]{-1}, expected);
    }

}