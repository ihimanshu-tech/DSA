/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode nodeBeforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            nodeBeforeLeft = nodeBeforeLeft.next;
        }
        
        ListNode rightmost = dummy;
        for (int i = 0; i < right; i++) {
            rightmost = rightmost.next;
        }
        
        ListNode nodeAfterRight = rightmost.next;
        
        ListNode prev = nodeAfterRight;
        ListNode current = nodeBeforeLeft.next; 
        
        while (current != nodeAfterRight) {
            ListNode nextTemp = current.next;      
            current.next = prev;    
            prev = current;
            current = nextTemp;
        }
        
        nodeBeforeLeft.next = prev;
        
        return dummy.next;
    }
}