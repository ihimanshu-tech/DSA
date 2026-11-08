#include <vector>
#include <queue>
#include <tuple>

using namespace std;

class Solution { 
public: 
    typedef pair<int,int> P; //wt,idx 
    typedef tuple<long,int,int> T; //fintime,wt,idx 
    
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) { 
        int n = servers.size(); 
        int m = tasks.size(); 
        
        //free servers (wt,idx) 
        priority_queue<P,vector<P>, greater<P>> freeServers; 
        //Busy Servers(fintme,wt,idx); 
        priority_queue<T,vector<T>, greater<T>> busyServers; 
        
        for(int i = 0;i<n;i++){ 
            freeServers.push({servers[i],i}); 
        } 
        
        vector<int> result(m); // Renamed to result to match your inner loop usage
        long i = 0; // Tracks the current simulation time
        
        for(int t = 0; t < m; t++){ 
            i = max(i, (long)t);
            
            if(freeServers.empty() && !busyServers.empty()){
                i = max(i, get<0>(busyServers.top()));
            }
            
            //Move busy severs to free servers if they are ffree at ith time 
            while(!busyServers.empty() && get<0>(busyServers.top()) <= i){ 
                auto [finTime,wt,idx] = busyServers.top(); 
                busyServers.pop(); 
                freeServers.push({wt,idx}); 
            } 
            
            if(freeServers.empty()){ 
                auto [finTime,wt,idx] = busyServers.top(); 
                busyServers.pop(); 
                result[t] = idx; 
                busyServers.push({finTime+tasks[t], wt,idx}); 
            }else{ 
                auto [wt,idx] = freeServers.top(); 
                freeServers.pop(); 
                result[t] = idx; 
                busyServers.push({i + tasks[t],wt,idx}); 
            } 
        } 
        return result;
    } 
};
