/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *head1, ListNode *head2) {
         	// Search it in first list
    while (head2 != nullptr) {
        ListNode *temp = head1;
        while (temp) {
          
            // If both Nodes are same
            if (temp == head2)
                return head2;
            temp = temp->next;
        }
        head2 = head2->next;
    }
  	
    // intersection is not present between the lists
    return nullptr;
    }
};