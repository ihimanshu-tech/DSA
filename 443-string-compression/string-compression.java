class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        for(int i =0;i<chars.length;){
            char current = chars[i];
            int count = 0;
            while(i<n && chars[i] == current){
                i++;
                count++;
            }
            chars[index++] = current;
            if(count>1){
                String cnt = String.valueOf(count);

                for(int j = 0;j<cnt.length() ; j++){
                    chars[index++] = cnt.charAt(j); 
                }
            }
        }
        return index;
    }
}