class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        int n = s.length();
        while(right<n){
            char ch = s.charAt(right);
            if(lastSeen.containsKey(ch)){
                left= Math.max(left,lastSeen.get(ch) + 1);
            }
            lastSeen.put(ch,right);
            maxLength = Math.max(maxLength, right - left +1);
            right++;
        }
        return maxLength;
    }
}