class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;

        // Check first row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        // Mark zeros using first row & column
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix cells to zero
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (row0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (col0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
