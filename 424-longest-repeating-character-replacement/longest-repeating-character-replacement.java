class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0, right = 0;
        int freq = 0, res = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            mp.put(c, mp.getOrDefault(c,0) + 1);
            freq = Math.max(freq,mp.get(c));
            int len = right - left + 1;

            if(len-freq>k){
                char leftChar = s.charAt(left); 
                mp.put(leftChar, mp.getOrDefault(leftChar,0) - 1);
                left++;
                len = right - left + 1;
            }
            res = Math.max(res,len);
            right++;
        }
    return res;
    }
}