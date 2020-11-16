package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomMinesGenerator {
    public static int[] generate(int rows, int cols, int mines) {
        int[] minesPosition;
        try {
            int[] allCells = new int[rows*cols];
            if(rows<=0 || cols <= 0){return new int[]{-1};}
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < allCells.length; i++) {
                integerList.add(i);
            }
            Collections.shuffle(integerList);

            minesPosition = integerList.stream().mapToInt(i -> i).toArray();
            return Arrays.copyOfRange(minesPosition, 0, mines);

        } catch (Exception exception) {
            return new int[]{-1};
        }

    }
}
