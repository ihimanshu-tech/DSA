class Solution {
    public String validIPAddress(String queryIP) {
        // Handle edge cases where string starts or ends with delimiters
        if (queryIP.length() == 0 || queryIP.startsWith(".") || queryIP.endsWith(".") 
            || queryIP.startsWith(":") || queryIP.endsWith(":")) {
            return "Neither";
        }

        // Detect if it's IPv4 or IPv6 based on the containing character
        if (queryIP.contains(".")) {
            // Split by '.' (we use -1 to preserve trailing empty splits, though handled above)
            String[] parts = queryIP.split("\\.", -1);
            if (parts.length == 4) {
                for (String part : parts) {
                    if (!isValidIPv4Part(part)) {
                        return "Neither";
                    }
                }
                return "IPv4";
            }
        } else if (queryIP.contains(":")) {
            // Split by ':'
            String[] parts = queryIP.split(":", -1);
            if (parts.length == 8) {
                for (String part : parts) {
                    if (!isValidIPv6Part(part)) {
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        }

        return "Neither";
    }

    // Helper to validate a single IPv4 segment (your 'ipv4' approach corrected)
    private boolean isValidIPv4Part(String part) {
        // Check length constraints (1 to 3 digits)
        if (part.length() == 0 || part.length() > 3) {
            return false;
        }
        
        // Check for leading zeros (e.g., "01" is invalid, but "0" is valid)
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        
        // Check if all characters are digits and value is <= 255
        int value = 0;
        for (int i = 0; i < part.length(); i++) {
            char ch = part.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
            value = value * 10 + (ch - '0');
        }
        
        return value <= 255;
    }

    // Helper to validate a single IPv6 segment
    private boolean isValidIPv6Part(String part) {
        // Check length constraints (1 to 4 hex digits)
        if (part.length() == 0 || part.length() > 4) {
            return false;
        }
        
        // Check if all characters are valid hexadecimals
        for (int i = 0; i < part.length(); i++) {
            char ch = part.charAt(i);
            boolean isDigit = ch >= '0' && ch <= '9';
            boolean isUpperCaseHex = ch >= 'A' && ch <= 'F';
            boolean isLowerCaseHex = ch >= 'a' && ch <= 'f';
            
            if (!isDigit && !isUpperCaseHex && !isLowerCaseHex) {
                return false;
            }
        }
        return true;
    }
}
