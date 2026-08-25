class Solution {
    private:
        bool dfs(int node,vector<int> &vis, vector<vector<int>> &adj){
            vis[node] = 1;
            for(int adjacentNode : adj[node]){
                if(vis[adjacentNode] == 0){
                    if(dfs(adjacentNode,vis,adj) == true)
                        return true;
                }
                else if(vis[adjacentNode] == 1) return true;
                //Note : if state=2, we skipped safely   
            }
            vis[node] =2;
            return false;
        }
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {  
        vector<vector<int>> adj(numCourses);
        for(auto& edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            adj[prerequisite].push_back(course);
        }
        vector<int> vis(numCourses,0);
        for(int i=0;i<numCourses;i++){
            if(vis[i] == 0)
                if(dfs(i,vis,adj) ==true) return false;
        }
        return true;
    }
};