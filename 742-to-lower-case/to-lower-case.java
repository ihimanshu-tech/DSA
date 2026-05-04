class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if the character is within the Uppercase ASCII range (65-90)
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Adding 32 converts Uppercase to Lowercase
                chars[i] += 32;
            }
        }
        
        return new String(chars);
    }
}