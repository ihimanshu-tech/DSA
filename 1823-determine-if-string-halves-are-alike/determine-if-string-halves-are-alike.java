class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int countVowels1 = 0;
        int countVowels2 = 0;
        for(int i=0;i<n/2;i++){
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'|| 
            arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U'){
                countVowels1++;
            }
        }
        for(int i=n/2;i<n;i++){
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'|| 
            arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U'){
                countVowels2++;
            }
        }
        if(countVowels1 == countVowels2){
            return true;
        }
        return false;
    }
}
