/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // T- O(n+m)
 // S- O(n)
 // hashset + sll
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> sett = new HashSet<ListNode>();
        ListNode mover = headA;
        while (mover != null){
            sett.add(mover);
            mover = mover.next;
        }
        mover = headB;
        while (mover != null){
            if (sett.contains(mover)) return mover;
            mover = mover.next;
        }
        return null;
    }
}