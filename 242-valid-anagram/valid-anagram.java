class Solution {
    public boolean isAnagram(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i] != arr2[i]){
                        return false;
                    }
                }
            return true;
            }
        return false;
    }
}