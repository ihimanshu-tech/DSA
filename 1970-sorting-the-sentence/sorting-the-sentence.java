class Solution {
    public String sortSentence(String s) {
        // 1. Split the shuffled sentence into individual words
        String[] words = s.split(" ");
        String[] res = new String[words.length];
        
        for (String word : words) {
            // 2. Get the last character (the digit) and convert to index
            int lastIdx = word.length() - 1;
            int position = Character.getNumericValue(word.charAt(lastIdx)) - 1;
            
            // 3. Store the word in the result array without the trailing digit
            res[position] = word.substring(0, lastIdx);
        }
        
        // 4. Join the words back together with a space
        return String.join(" ", res);
    }
}