package lecture01WorkingWithAbstraction.E05JediGalaxy;

import java.util.ArrayList;
import java.util.List;

public class Evil extends Actor {


    public List<int[]> getDestroyedCells(int[] galaxyDimensions) {
        int numRows = galaxyDimensions[0];
        int numCols = galaxyDimensions[1];

        List<int[]> destroyedCells = new ArrayList<>();
        while (row >= 0 && col >= 0) {
            if (row < numRows && col < numCols) {
                destroyedCells.add(new int[]{row, col});
            }
            row--;
            col--;
        }
        return destroyedCells;
    }
}
