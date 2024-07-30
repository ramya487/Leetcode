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
 // T- O(2N) + O(nlogn)
 // S- O(N)
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        List<Integer> ls = new ArrayList<Integer>();
        ListNode mover = head;
        while (mover != null){
            ls.add(mover.val);
            mover = mover.next;
        }
        Collections.sort(ls);
        System.out.println(ls);
        head = new ListNode(ls.get(0));
        mover = head;
        for (int i = 1; i<ls.size(); i++){
            ListNode temp = new ListNode(ls.get(i));
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
}