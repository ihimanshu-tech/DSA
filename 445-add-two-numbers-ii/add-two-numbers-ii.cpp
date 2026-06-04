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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* ans = new ListNode(0);
        ListNode* curr = ans;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode* a = l1, *b = l2;
        int carry =0;
        while(a || b){
            int  x = a ? a->val : 0;
            int  y = b ? b->val : 0;

            int sum = carry + x + y;
            carry = sum/10;

            curr->next = new ListNode(sum%10);
            curr = curr->next;

            if(a)
                a = a->next;
            if(b)
                b = b->next;
        }
        if(carry>0)
            curr->next = new ListNode(carry);
        return reverse(ans->next) ;
        }

    private:
        ListNode* reverse(ListNode* head) {
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