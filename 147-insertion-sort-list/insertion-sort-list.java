class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        // Dummy node (helps simplify insertion at head)
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            ListNode next = curr.next; // store next node

            // Find correct position in sorted list
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to next node
            curr = next;
        }

        return dummy.next;
    }
}