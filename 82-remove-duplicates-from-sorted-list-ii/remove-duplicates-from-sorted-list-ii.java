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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null)
        {
            int len=0;
            while(fast!=null && slow.val==fast.val)
            {
                fast=fast.next;
                len++;
            }
            if(len>1)  
                curr.next=fast;
            else
                curr=curr.next;
            slow=fast;
        }
        return dummy.next;
    }
}