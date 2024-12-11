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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        int ans = 0;
        ListNode temp = head;
        while(temp!=null){
            if(set.contains(temp.val)){
                ans++;
                while(temp!=null&&set.contains(temp.val))
                    temp= temp.next;
            }
            else{
                temp = temp.next;
            }
        }
        return ans;
    }
}