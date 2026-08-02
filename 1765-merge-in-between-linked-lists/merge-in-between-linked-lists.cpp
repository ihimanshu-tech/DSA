class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* prevA = list1;
        ListNode* afterB = list1;

        // Find the (a - 1)-th node
        for (int i = 0; i < a - 1; ++i) {
            prevA = prevA->next;
        }

        // Find the (b + 1)-th node
        for (int i = 0; i <= b; ++i) {
            afterB = afterB->next;
        }

        // Find the tail of list2
        ListNode* tail2 = list2;
        while (tail2->next != nullptr) {
            tail2 = tail2->next;
        }

        // Connect (a - 1)-th node to head of list2
        prevA->next = list2;

        // Connect tail of list2 to (b + 1)-th node
        tail2->next = afterB;

        return list1;
    }
};