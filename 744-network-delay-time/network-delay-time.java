import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Graph banane ke liye Adjacency List: Map<SourceNode, List<[NeighborNode, Time]>>
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        
        // Min-Priority Queue taaki sabse kam travel time wala node pehle nikle: [total_distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        // Track karne ke liye ki kaunse nodes poore process ho chuke hain
        boolean[] visited = new boolean[n + 1];
        
        // Starting node 'k' se baki saare nodes tak ka minimum distance store karne ke liye array
        int[] minDis = new int[n + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE); // Shuru me saare cells ko infinity (MAX_VALUE) set kiya
        
        // Starting node 'k' ka khud se distance 0 hoga
        minDis[k] = 0;
        pq.offer(new int[] { 0, k }); // Priority queue me start node daala: [distance=0, node=k]
        
        int max = 0; // Yeh track karega ki aakhiri node tak pahunchne me maximum kitna time laga
        
        // Dijkstra's algorithm ka main loop
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Sabse kam distance wala node queue se nikala
            int currNode = curr[1];
            int currDis = curr[0];
            
            // Agar node pehle hi visit ho chuka hai toh skip karo (duplicate entry check)
            if (visited[currNode])
                continue;
            
            // Node ko permanently visited mark kiya aur iska shortest distance lock ho gaya
            visited[currNode] = true;
            max = currDis; // PQ se values badhte kram (increasing order) me niklengi, toh aakhiri value hi max hogi
            n--;           // Ek node mil gaya, toh bache hue unvisited nodes ka count kam kiya
            
            // Agar current node se aage koi raasta (outgoing edge) nahi hai, toh aage badho
            if (!graph.containsKey(currNode))
                continue;
                
            // Current node ke saare padosi (neighbors) ko check karo
            for (int[] next : graph.get(currNode)) {
                int nextNode = next[0];
                int travelTime = next[1];
                
                // Agar padosi node visited nahi hai AUR current node se hokar naya raasta pehle se chota hai
                if (!visited[nextNode] && currDis + travelTime < minDis[nextNode]) {
                    // CRITICAL FIX: minDis array ko update karna zaroori hai taaki queue me faltu/lambe raaste baar-baar na jayen
                    minDis[nextNode] = currDis + travelTime; 
                    pq.offer(new int[] { minDis[nextNode], nextNode });
                }
            }
        }
        
        // Agar saare 'n' nodes tak signal pahunch gaya (n == 0), toh max time return karo; nahi toh -1
        return n == 0 ? max : -1;
    }
}
