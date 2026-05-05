class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int n = command.length();
        char[] ch = command.toCharArray();
        for (int i =0 ; i<n;i++) {
            if (ch[i] == '(' && ch[i+1] == ')') {
                sb.append("o");
                i++;
            }
            if (ch[i] == '(' || ch[i] == ')') {
                // sb.append();
                continue;
            }
            else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}