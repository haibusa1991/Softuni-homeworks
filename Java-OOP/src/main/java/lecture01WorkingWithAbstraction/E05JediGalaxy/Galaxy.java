package lecture01WorkingWithAbstraction.E05JediGalaxy;

import java.util.List;

public class Galaxy {
    private final int rows;
    private final int cols;
    private final int[][] matrix;

    public Galaxy(int[] dimensions) {
        this.rows = dimensions[0];
        this.cols = dimensions[1];
        this.matrix = new int[rows][cols];
        fillMatrix();
    }

    private void fillMatrix() {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public int[] getDimensions() {
        return new int[]{rows, cols};
    }

    public void destroyCells(List<int[]> cells) {
        for (int[] cell : cells) {
            int r = cell[0];
            int c = cell[1];
            matrix[r][c] = 0;
        }
    }

    public long getSumOfCells(List<int[]> cells) {
        long result = 0;
        for (int[] cell : cells) {
            int r = cell[0];
            int c = cell[1];
            result += matrix[r][c];
        }
        return result;
    }
}
