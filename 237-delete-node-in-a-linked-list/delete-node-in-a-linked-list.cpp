class Solution {
public:
    void deleteNode(ListNode* node) {
        // Copy the data from the next node into this node
        node->val = node->next->val;
        
        // Store the pointer to the next node so we can delete it from memory safely
        ListNode* temp = node->next;
        
        // Skip the next node
        node->next = node->next->next;
        
        // Free the memory of the original next node
        delete temp;
    }
};