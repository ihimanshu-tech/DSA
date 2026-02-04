class Solution {
    public int numberOfSteps(int num) {
        
            int steps = 0;
            if (num == 0){
                return 0; //base condition
            }
            if (num % 2 == 0){
                return 1 + numberOfSteps(num/2);
            }
            else{
                return 1 + numberOfSteps(num -1);
            }
        }
}
