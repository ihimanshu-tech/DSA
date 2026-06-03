class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) 
            return head;
        
        ListNode* mid = findMid(head);
        ListNode* rightHead = mid->next;
        mid->next = nullptr;
        
        ListNode* left = sortList(head);
        ListNode* right = sortList(rightHead);
        
        return merge(left, right);
    }

private:
    ListNode* merge(ListNode* a, ListNode* b) {
        if (!a) return b;
        if (!b) return a;
        
        ListNode* temp = new ListNode(0);
        ListNode* curr = temp;

        while (a && b) {
            if (a->val < b->val) {
                curr->next = a;
                a = a->next;
            } else {
                curr->next = b;
                b = b->next;
            }
            curr = curr->next;
        }
        
        // Attach whatever is left over from a or b (Moved OUTSIDE the while loop)
        if (a) {
            curr->next = a;
        }
        if (b) {
            curr->next = b;
        }
        
        ListNode* ans = temp->next;
        return ans;
    }
    
    ListNode* findMid(ListNode* head) {
        // Fixed the base case logic
        if (!head || !head->next) 
            return head;
            
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }
};