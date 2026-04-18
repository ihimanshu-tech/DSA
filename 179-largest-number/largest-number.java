class Solution {
    public String largestNumber(int[] nums) {

        // Convert to String array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        int i = 0;

        while (i < arr.length - 1) {
            int j = i + 1;   // reset j every time

            while (j < arr.length) {

                // Compare (a+b) vs (b+a)
                if ((arr[i] + arr[j]).compareTo(arr[j] + arr[i]) < 0) {
                    
                    // swap
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

                j++;
            }
            i++;
        }

        // Edge case: leading zero
        if (arr[0].equals("0")) return "0";

        // Build result
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}