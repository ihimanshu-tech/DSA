class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        double sum = 0;
        double avg = -Double.MAX_VALUE;
        
        while (r < n) {
            sum += nums[r];
            if ((r - l + 1) == k) {
                avg = avg > (sum / k) ? avg : (sum / k);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        
        return avg;
    }
}