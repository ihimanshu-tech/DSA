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
    ListNode* getIntersectionNode(ListNode* head1, ListNode* head2) {
        unordered_set<ListNode*> visNode;
        ListNode *curr1 = head1;
        while (curr1 != nullptr) {
            visNode.insert(curr1);
            curr1 = curr1->next;
        }
        ListNode *curr2 = head2;
        while(curr2){
            if(visNode.find(curr2) != visNode.end()){
                return curr2;
            }
            curr2 = curr2->next;
        }
        // intersection is not present between the lists
        return nullptr;
    }
};