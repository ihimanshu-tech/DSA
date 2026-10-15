class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(candidates, 0, temp, ans, target);
        return ans;
    }

    void solve(int[] arr, int i, List<Integer> temp, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || i == arr.length)
            return;

        temp.add(arr[i]);
        solve(arr, i, temp, ans, target - arr[i]); //include

        temp.remove(temp.size() - 1); //backtracking
        solve(arr, i + 1, temp, ans, target);

    }
}