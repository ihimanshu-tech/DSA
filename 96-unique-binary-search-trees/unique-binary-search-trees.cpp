class Solution {
public:
    int numTrees(int n) {
        long long fact = 1;
        for(int i=0;i<n;i++){
            fact*= (2*n-i);
            fact = fact / (i+1);
        }
        return fact/(n+1);
    }
};