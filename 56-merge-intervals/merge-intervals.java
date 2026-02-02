import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals (same as sort(begin, end) in C++)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        // Push first interval
        ans.add(intervals[0]);

        // Traverse from second interval
        for (int i = 1; i < intervals.length; i++) {

            // If overlapping
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {

                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);

            } else {
                ans.add(intervals[i]);
            }
        }

        // Convert List to 2D array
        return ans.toArray(new int[ans.size()][]);
    }
}
