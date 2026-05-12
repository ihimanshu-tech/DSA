class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // The maximum Manhattan distance in a grid is (rows-1) + (cols-1)
        int maxDist = rows + cols - 2;
        
        // Create buckets for each possible distance
        // Each bucket will store coordinates [r, c]
        List<int[]>[] buckets = new List[maxDist + 1];
        for (int i = 0; i <= maxDist; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Fill buckets: O(R * C)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                buckets[dist].add(new int[]{r, c});
            }
        }

        // Flatten buckets into the result array: O(R * C)
        int[][] result = new int[rows * cols][2];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] cell : buckets[i]) {
                result[index++] = cell;
            }
        }

        return result;
    }
}