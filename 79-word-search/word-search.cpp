class Solution {
    bool solve(int i,int j,int x,vector<vector<char>> &board,string &word){
        if(x==word.size())
            return true;
        int m = board.size();
        int n = board[0].size();
        if(i<0 || i>=m || j<0 || j>=n|| board[i][j] !=word[x] || board[i][j] == '.')
            return false;
        char temp = board[i][j];
        board[i][j] ='.';

        bool res = solve(i,j+1,x+1,board,word) || solve(i+1,j,x+1,board,word) || solve(i,j-1,x+1,board,word) || solve(i-1,j,x+1,board,word);

        board[i][j] = temp;

        return res;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word[0] && solve(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
};