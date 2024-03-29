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
    public ListNode reverseList(ListNode head) {
        //最后一个节点指向null
        ListNode dummy = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = next;
        }
        return dummy;
    }
}
