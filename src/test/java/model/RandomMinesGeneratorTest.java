package model;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RandomMinesGeneratorTest extends TestCase {

    public void testSizeGeneratedArray(){
        int[] expected = IRandomMinesGenerator.generate(10, 8, 3);
        assertEquals(3, expected.length);

        int[] expected1 = IRandomMinesGenerator.generate(10, 8, 1);
        assertEquals(1, expected1.length);

        int[] expected2 = IRandomMinesGenerator.generate(10, 8, 5);
        assertEquals(5, expected2.length);

    }

    public void testPassedNegativeValueReturnsArrayWithMinusOne(){
        int[] expected = IRandomMinesGenerator.generate(10, 8, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(-1, 8, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(2, -1, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(-1, -1, 1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(2, -1, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(-1, 1, -1);
        assert Arrays.equals(new int[]{-1}, expected);

        expected = IRandomMinesGenerator.generate(-1, -1, -1);
        assert Arrays.equals(new int[]{-1}, expected);
    }

}