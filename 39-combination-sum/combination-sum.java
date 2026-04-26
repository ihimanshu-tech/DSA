import java.util.ArrayList;
class Solution {

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();

        cS(arr, 0, combi, ans, target);
        return ans;
    }
    //helper function
    void cS(int[] arr, int i, List<Integer> combi, List<List<Integer>> ans, int target) {

        // Base case
        if (target == 0) {
            ans.add(new ArrayList<>(combi));
            return;
        }

        if (target < 0 || i == arr.length) return;

        // INCLUDE (same index → reuse allowed)
        combi.add(arr[i]);
        cS(arr, i, combi, ans, target - arr[i]);

        // BACKTRACK
        combi.remove(combi.size() - 1);

        // EXCLUDE (move to next index)
        cS(arr, i + 1, combi, ans, target);
    }
}