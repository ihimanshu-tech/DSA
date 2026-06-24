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

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right)
 *         : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:

    ListNode* middleNode(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = nullptr;

        while(fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }

        // break left half from middle
        if(prev)
            prev->next = nullptr;

        return slow;
    }

    TreeNode* sortedListToBST(ListNode* head) {

        if(head == nullptr)
            return nullptr;

        if(head->next == nullptr)
            return new TreeNode(head->val);

        ListNode* mid = middleNode(head);

        TreeNode* root = new TreeNode(mid->val);

        // left half starts from head
        root->left = sortedListToBST(head);

        // right half starts from mid->next
        root->right = sortedListToBST(mid->next);

        return root;
    }
};