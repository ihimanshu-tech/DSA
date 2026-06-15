class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) 
            return head;
   
        vector<ListNode*> arr;
        while(head){
            arr.push_back(head);
            head = head->next;
        }
        mergeSort(arr,0,arr.size()-1);
        for(int i =0;i<arr.size()-1;i++){
            arr[i]->next = arr[i+1];
        }
        arr[arr.size()-1]->next =nullptr;
        return arr[0];
    }

private:
    void mergeSort(vector<ListNode*>& arr,int s,int e) {
            if(s>=e){
                return;
            }
            int mid = s +(e-s)/2;
            mergeSort(arr,s,mid);
            mergeSort(arr,mid+1,e);
            merge(arr,s,e);
        }
    void merge(vector<ListNode*>& arr,int s,int e){
        vector<ListNode*> mix;
        int mid = s+(e-s)/2;
        int i= s ,j = mid+1;
        while(i<=mid && j<=e){
            if(arr[i]->val<=arr[j]->val){
                mix.push_back(arr[i]);
                i++;
            }
            else{
                mix.push_back(arr[j]);
                j++;
            }   
        }
        while(i<=mid){
            mix.push_back(arr[i]);
            i++;            
        } 
        while(j<=e){
            mix.push_back(arr[j]);
            j++;            
        } 
        for(int i=s,j=0;i<=e;i++,j++){
            arr[i] = mix[j];
        }
    }
};