class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        for(int i= 0; i<arr.length;i++)
            arr[indices[i]] = s.charAt(i);
    return new String(arr);
    }
}