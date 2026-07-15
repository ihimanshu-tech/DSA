class Solution {
public:
    bool checkValidString(string s) {
        stack<int> stkA, stkB;
        for(int i=0;i<s.size();i++){
            if(s[i]=='(')
                stkA.push(i);
            else if(s[i]==')'){
                if(!stkA.empty())
                    stkA.pop(); 
            else if(!stkB.empty())
                stkB.pop();
            else
                return false;
            }
            else
                stkB.push(i);
        }
        while(!stkA.empty()){
            if(stkB.empty())
                return false;
            if(stkA.top() > stkB.top())
                return false;
            stkA.pop();
            stkB.pop();

        }
        return true;
    }
};