class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* first = list1;
        ListNode* sec = list1;

        for (int count1 = 0; count1 < a - 1; count1++) {
            first = first->next;
        }

        for (int count2 = 0; count2 < b; count2++) {
            sec = sec->next;
        }

        ListNode* end = list2;
        while (end && end->next) {
            end = end->next;
        }

        first->next = list2;
        end->next = sec->next;

        return list1;
    }
};