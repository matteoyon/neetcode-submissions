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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast;

        if(slow == null || slow.next == null) return false;

        fast = slow.next;

        while(fast != null){
            if(fast == slow) return true;
            if(fast.next == null) return false;
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        return false;
    }
}
