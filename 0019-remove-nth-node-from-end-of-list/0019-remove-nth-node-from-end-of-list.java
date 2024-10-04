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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        int length = 0;
        ListNode ptr_len = head;
        while (ptr_len != null){
            length++;
            ptr_len = ptr_len.next;
        }
        if (length == 1){
            head = null;
            return head;
        }
        int index = length-n;
        if (index == 0){
            head = head.next;
            return head;
        }
        ListNode pptr = head;
        ListNode ptr = head.next;
        int counter = 1;
        while (counter != index){
            pptr = ptr;
            ptr = ptr.next;
            counter++;
        }
        pptr.next = ptr.next;
        return head;
    }
}