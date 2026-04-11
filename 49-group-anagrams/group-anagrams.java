import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Check for empty inputs
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        
        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        
        for (String str : strs) {
            
            String frequencyString = getFrequencyString(str);
            
            // If the frequency string is present, add the string to the list
            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                // else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }
        
        return new ArrayList<>(frequencyStringsMap.values());
    }
    
    private String getFrequencyString(String str) {
        int[] count = new int[26];
        
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        
        return Arrays.toString(count);
    }
}