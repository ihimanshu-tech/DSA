class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0) + 1);
        }
        // The element with the smallest frequency stays at the top of the heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->mp.get(a) - mp.get(b));
        for(int key:mp.keySet()){
            minHeap.add(key);
            // If heap size exceeds k, remove the element with the lowest frequency
            if(minHeap.size()>k)
                minHeap.poll();
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = minHeap.poll();
        }
    return ans;
    }
}