/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    ListNode* merge(ListNode* a,ListNode* b){
        if(a==nullptr) return b;
        if(b==nullptr) return a;
        if(a->val <b->val){
            a->next =merge(a->next,b);
            return a;
        }
        else{
            b->next = merge(a,b->next);
            return b;
        }

    }
    ListNode* mergeSort(vector<ListNode*> &arr,int low,int high){
        if(low==high){
            return arr[low];
        }
        int mid = low +(high-low)/2;
        ListNode* a = mergeSort(arr,low,mid);
        ListNode* b = mergeSort(arr,mid+1,high);
        return merge(a,b);
    }
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==1) return lists[0];
        if(lists.size()==0) return nullptr;
        return mergeSort(lists,0,lists.size()-1);
        
        }
};