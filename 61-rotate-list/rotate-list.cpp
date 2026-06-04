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
public:
    ListNode* rotateRight(ListNode* head, int k) {
        int len = 1;

        if(!head || !head->next || k==0) return head;

        ListNode* tail = head;
        while(tail->next){
            len++;
            tail = tail->next;
        }

        k = k%len;
        if(k == 0) return head;

        tail->next = head;
        

        ListNode * newTail = head;
        int newTailPos = len-k-1;

        while(newTailPos>0){
            newTail = newTail->next;
            newTailPos--;
        }

        ListNode* newHead = newTail->next;
        newTail->next = nullptr;

        return newHead;        
    }
};