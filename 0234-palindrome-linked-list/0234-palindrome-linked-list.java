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
 // T-O(2N)
 // S-O(N)
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode mover = head;
        while (mover != null){
            s.push(mover.val);
            mover = mover.next;
        }
        mover = head;
        while (!s.empty()){
            if (s.pop() != mover.val) return false;
            mover = mover.next;
        }
        return true;
    }
}