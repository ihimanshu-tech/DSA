class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge case for zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // The max possible length of the product of two numbers is m + n
        int[] result = new int[m + n];
        
        // Multiply from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Convert characters to actual numeric digits
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Determine positions in the result array
                int p1 = i + j;     // Carry position
                int p2 = i + j + 1; // Current position
                
                // Add current multiplication to what's already in the slot
                int sum = mul + result[p2];
                
                // Store the units digit and carry the tens digit
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        // Convert the integer array back to a String
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip any leading zeros at the very front
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.toString();
    }
}
