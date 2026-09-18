class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        Arrays.sort(arr_s);
        Arrays.sort(arr_t);
        for(int i=0;i<arr_s.length;i++){
            if(arr_s[i] != arr_t[i])
                return false;
        }
        return true;
    }
}