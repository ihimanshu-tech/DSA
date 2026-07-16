class Solution {
    void dfs(vector<vector<char>> &grid, int row, int col,vector<vector<int>> &visited){
        int n = grid.size();
        int m = grid[0].size();
        visited[row][col] = 1;

        int dRow[] = {-1,0,1,0};
        int dCol[] = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row +dRow[i];
            int ncol = col +dCol[i];

            if(nrow >= 0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !visited[nrow][ncol])
            {
                dfs(grid,nrow,ncol,visited);
            }
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> visited(n,vector<int>(m,0));
        int islands=0;
        for(int i =0; i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands ++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return islands;
    }
};