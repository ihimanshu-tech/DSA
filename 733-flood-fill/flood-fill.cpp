class Solution {
private:
    void dfs(int row, int col, vector<vector<int>>& image, int initialColor, int newColor, int delRow[], int delCol[]) {
        int n = image.size();
        int m = image[0].size();
        
        image[row][col] = newColor;
        

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor) {
                dfs(nrow, ncol, image, initialColor, newColor, delRow, delCol);
            }
        }
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        
        if (initialColor == color) return image;
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        dfs(sr, sc, image, initialColor, color, delRow, delCol);
        
        return image;
    }
};