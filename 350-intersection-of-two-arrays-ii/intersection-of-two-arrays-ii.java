import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // ArrayList<Integer> set1 = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int num : nums1) {
            // set1.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }
}