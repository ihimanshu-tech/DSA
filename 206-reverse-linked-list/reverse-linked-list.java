/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            // 1. Temporarily store the next node
            ListNode nextTemp = current.next; 
            
            // 2. Flip the pointer to face backward
            current.next = prev; 
            
            // 3. Move prev and current forward one step
            prev = current;
            current = nextTemp;
        }
        
        // After the loop, prev will be the new head
        return prev;
    }
}