package model;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RandomMinesGeneratorTest extends TestCase {

    public void testSizeGeneratedArray(){
        int[] expected = RandomMinesGenerator.generate(10, 8, 3);
        assertEquals(3, expected.length);

        int[] expected1 = RandomMinesGenerator.generate(10, 8, 1);
        assertEquals(1, expected1.length);

        int[] expected2 = RandomMinesGenerator.generate(10, 8, 5);
        assertEquals(5, expected2.length);

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