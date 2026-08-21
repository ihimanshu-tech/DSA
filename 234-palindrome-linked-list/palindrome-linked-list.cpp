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
    bool isPalindrome(ListNode* head) {
        ListNode* ptr = head;
        stack<ListNode*> st;
        if(head==nullptr || head->next == nullptr)
            return true;
        ListNode* curr = middle(head);
        while(curr!=nullptr){
            st.push(curr);
            curr = curr->next;
        }
        while(!st.empty()){
            if(st.top()->val != ptr->val)
                return false;
            st.pop();
            ptr = ptr->next;
        }
        return true;
    }
    ListNode* middle(ListNode* head){
       if(head==nullptr || head->next == nullptr)
            return head;
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast!=nullptr && fast->next !=nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
    return slow;    
    }
};