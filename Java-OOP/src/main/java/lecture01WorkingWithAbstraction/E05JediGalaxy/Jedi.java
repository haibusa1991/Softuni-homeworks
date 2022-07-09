package lecture01WorkingWithAbstraction.E05JediGalaxy;

import java.util.ArrayList;
import java.util.List;

public class Jedi extends Actor {
    private long score;

    public List<int[]> getVisitedCells(int[] galaxyDimensions) {
        int numRows = galaxyDimensions[0];
        int numCols = galaxyDimensions[1];

        List<int[]> visitedCells = new ArrayList<>();

        while (row >= 0 && col < numCols) {
            if (row < numRows && col >= 0) {
                visitedCells.add(new int[]{row, col});
            }

            col++;
            row--;
        }

        return visitedCells;
    }

    public void addScore(long score) {
        this.score += score;
    }

    public long getScore() {
        return score;
    }
}
