class Solution {
    static bool solve(ListNode* a,ListNode* b){
        return a->val<b->val;
    }
public:
//method 2 - inbuilt sort function
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) 
            return head;
   
        vector<ListNode*> arr;
        while(head){
            arr.push_back(head);
            head = head->next;
        }
        // mergeSort(arr,0,arr.size()-1);
        sort(arr.begin(),arr.end(),solve);
        for(int i =0;i<arr.size()-1;i++){
            arr[i]->next = arr[i+1];
        }
        arr[arr.size()-1]->next =nullptr;
        return arr[0];
    }
};