class Solution {
    public boolean containsDuplicate(int[] nums) {
        int xorr = 0;
        HashSet<Integer> seen = new HashSet<>();
        for(int num: nums){
            if(!seen.add(num))
                return true;
        }
        return false;
    }
}