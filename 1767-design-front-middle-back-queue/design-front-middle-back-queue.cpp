class FrontMiddleBackQueue {
    vector<int> q;
public:
    FrontMiddleBackQueue() {
        
    }
    
    void pushFront(int val) {
        q.insert(q.begin(),val);
    }
    
    void pushMiddle(int val) {
        int mid=q.size()/2;
        q.insert(q.begin() + mid ,val);
    }
    
    void pushBack(int val) {
        q.push_back(val);
        
    }
    
    int popFront() {
        if(q.size()==0) return -1;
        int a =q[0];
        q.erase(q.begin());
        return a;
    }
    
    int popMiddle() {
        if(q.size()==0) return -1;
        int mid =(q.size()-1)/2;
        int a =q[mid];
        q.erase(q.begin() +mid);
        return a;
        
    }
    
    int popBack() {
        if(q.size()==0) return -1;
        // int a =q[q.size()-1];
        int a = q.back();
        // q.erase(q.end());
        q.pop_back();
        return a;  
        
    }
};

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue* obj = new FrontMiddleBackQueue();
 * obj->pushFront(val);
 * obj->pushMiddle(val);
 * obj->pushBack(val);
 * int param_4 = obj->popFront();
 * int param_5 = obj->popMiddle();
 * int param_6 = obj->popBack();
 */