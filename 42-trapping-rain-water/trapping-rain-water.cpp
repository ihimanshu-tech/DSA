class Solution {
public:
    int trap(vector<int>& height) {
        int l = height.size();
        vector<int> left(l,0);
        vector<int> right(l,0);
        
        //left and right naam ka ek array bana lenge then maximum dekhenge jo trap kar sake
        for(int i=1;i<l;i++){
            left[i] = max(height[i-1], left[i-1]);
        }//left height
        for(int i=l-2;i>=0;i--){
            right[i] = max(height[i+1], right[i+1]);
        }//right height
        int trapped = 0;
        for(int i=1;i<l;i++){
            if(left[i]>height[i] && right[i]>height[i]){
                trapped += min(right[i],left[i]) -height[i]; 
            }
            
        }//traverse height        
        return trapped;        
    }
};