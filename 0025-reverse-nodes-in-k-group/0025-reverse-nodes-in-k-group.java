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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        // Dummy node helps manage changes to the head pointer easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            // Check if there are at least k nodes remaining
            ListNode groupTail = curr;
            for (int i = 1; i < k && groupTail != null; i++) {
                groupTail = groupTail.next;
            }
            
            // If fewer than k nodes remain, leave them as they are
            if (groupTail == null) {
                break;
            }
            
            // Save the start of the next group
            ListNode nextGroupHead = groupTail.next;
            
            // Reverse the current group of k nodes
            ListNode prev = nextGroupHead; // Pointing to next group head attaches the tail correctly
            ListNode currentGroupNode = curr;
            while (currentGroupNode != nextGroupHead) {
                ListNode nextNode = currentGroupNode.next;
                currentGroupNode.next = prev;
                prev = currentGroupNode;
                currentGroupNode = nextNode;
            }
            
            // Connect the previous group's tail to the new head of the reversed group
            prevGroupTail.next = groupTail;
            
            // Move prevGroupTail to the end of the reversed group (which was originally 'curr')
            prevGroupTail = curr;
            
            // Move to the next segment
            curr = nextGroupHead;
        }
        
        return dummy.next;
    }
}
