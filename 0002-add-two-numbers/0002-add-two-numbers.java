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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int init = 0;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        List<Integer> arr = new ArrayList<Integer>();
        while (ptr1 != null && ptr2 != null){
            int value = ptr1.val + ptr2.val;
            int value2 = value+init;
            arr.add(value2%10);
            init = value2/10;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr1 != null){
            int value = ptr1.val;
            int value2 = value + init;
            arr.add(value2%10);
            init = value2/10;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null){
            int value = ptr2.val;
            int value2 = value + init;
            arr.add(value2%10);
            init = value2/10;
            ptr2 = ptr2.next;
        }
        if (init != 0) arr.add(init);
        ListNode node = new ListNode(arr.get(0));
        ListNode head = node;
        for (int i = 1; i<arr.size(); i++){
            ListNode n = new ListNode(arr.get(i));
            node.next = n;
            node = n;
        }
        return head;
    }
}