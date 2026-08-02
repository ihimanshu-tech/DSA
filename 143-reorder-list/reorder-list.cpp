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
    void reorderList(ListNode* head) {
        if(!head || !head->next) return;
        ListNode* mid = middleNode(head);
        ListNode* second = reverse(mid->next);
        mid->next = nullptr;
        //Interleave and merge two halves

        ListNode* first = head;
        while(second){
            ListNode* temp1 = first->next;
            ListNode* temp2 = second->next;

            first->next = second;
            second->next = temp1;

            first = temp1;
            second = temp2;
        } 

    }
    ListNode* middleNode(ListNode* head){
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next; 
        }
        return slow;
    }
    ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* current = head;
        
        while (current != nullptr) {

            ListNode* nextTemp = current->next; 
            
            current->next = prev; 
            
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }

};