class BrowserHistory {
    
public:
    stack<string> st;
    stack<string> forwardSt;
    BrowserHistory(string homepage) {
        st.push(homepage);
    }
    
    void visit(string url) {
        st.push(url);
        while(!forwardSt.empty()){
            forwardSt.pop();
        }
    }
    
    string back(int steps) {
        while(steps>0 && st.size()>1){
            forwardSt.push(st.top());
            st.pop();
            steps--;
        }
        return st.top();
    }
    
    string forward(int steps) {
        while(steps>0 && !forwardSt.empty()){
            st.push(forwardSt.top());
            forwardSt.pop();
            steps--;
        }
        return st.top();
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */