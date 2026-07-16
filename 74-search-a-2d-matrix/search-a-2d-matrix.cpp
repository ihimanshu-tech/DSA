class Solution {
    bool binary(vector<int> & arr, int target) {
        int lo = 0, hi = arr.size()-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target == arr[mid]) {
                return true;
            }
            if (target < arr[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int lo = 0, hi = n - 1;
        int row = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (target == matrix[mid][0]) {
                return true;
            }

            if (target > matrix[mid][0]) {
                row = mid;
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        if (row == -1)
            return false;
        return binary(matrix[row],target);
    }
};