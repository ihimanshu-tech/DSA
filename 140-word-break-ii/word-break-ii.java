import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        List<String> result = new ArrayList<>();
        backtrack(s,wordSet,0,new StringBuilder(), result);
        return result;
    }
    private void backtrack(String s, Set<String> wordSet, int start, StringBuilder current,List<String> result){
        if(start == s.length()){
            result.add(current.toString().trim());
            return;
        }
        for (int end = start + 1; end<=s.length(); end++) {
            String word = s.substring(start,end);

            if(wordSet.contains(word)){
                int lenBefore = current.length();

                current.append(word).append(" ");

                backtrack(s,wordSet,end,current,result);
                current.setLength(lenBefore);
            }
            }
        }
}
