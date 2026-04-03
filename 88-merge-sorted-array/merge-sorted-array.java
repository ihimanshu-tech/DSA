class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the end of valid elements in nums1 and nums2
        int s = m - 1;
        int e = n - 1;
        // Pointer for the very end of the nums1 array
        int pSorted = m + n - 1;

        // While there are still elements to compare in both arrays
        while (e >= 0) {
            // If nums1 still has elements and its element is larger
            if (s >= 0 && nums1[s] > nums2[e]) {
                nums1[pSorted] = nums1[s];
                s--;
            } else {
                // Otherwise, the element from nums2 is larger or nums1 is empty
                nums1[pSorted] = nums2[e];
                e--;
            }
            pSorted--;
        }
    }
}