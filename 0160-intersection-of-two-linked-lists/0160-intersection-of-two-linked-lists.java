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
// T- O(n+m+time to reach the common node)
// S- O(1)
// ptrs + sll
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode mover = headA;
        int cA = 0;
        int cB = 0;
        while (mover != null){
            cA++;
            mover = mover.next;
        }
        mover = headB;
        while (mover != null){
            cB++;
            mover = mover.next;
        }
        int diff;

        ListNode moverA = headA;
        ListNode moverB = headB;

        if (cA > cB){
            diff = cA-cB;
            while (diff != 0){
                moverA = moverA.next;
                diff--;
            }
        }else{
            diff = cB-cA;
            while (diff != 0){
                moverB = moverB.next;
                diff--;
            }
        }

        while (moverA != moverB){
            moverA = moverA.next;
            moverB = moverB.next;
        }

        return moverA;
    }
}