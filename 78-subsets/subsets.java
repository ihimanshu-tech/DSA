import java.util.ArrayList;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List list = new ArrayList<Integer>();
        int n = 1 << nums.length;
        for (int i=0; i<n ; i++){
            List<Integer> currentSubset = new ArrayList<>();
            for (int j=0; j<nums.length ; j++){
                // int xor = nums[j] ^ i;
                // if(xor == 1){
                    if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            list.add(currentSubset);
        }
        return list;
    }
}