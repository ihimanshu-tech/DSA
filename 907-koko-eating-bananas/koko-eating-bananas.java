class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Find the maximum pile size for the upper bound of speed
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Safety check: mid could be 0 if low/high logic is wrong, 
            // but here low starts at 1.
            if (canFinish(piles, h, mid)) {
                result = mid;
                high = mid - 1; // Try to find a slower speed
            } else {
                low = mid + 1; // Need to eat faster!
            }
        }
        return result;
    }

    public boolean canFinish(int[] piles, int h, int mid) {
        long totalHours = 0; // Use long to prevent overflow
        for (int pile : piles) {
            // Ceiling division: (pile / mid) rounded up
            totalHours += (pile + mid - 1L) / mid;
        }
        return totalHours <= h;
    }
}