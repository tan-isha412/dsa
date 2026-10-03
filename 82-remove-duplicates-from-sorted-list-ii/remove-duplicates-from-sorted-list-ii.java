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
        ListNode dum=new ListNode(-101);
        dum.next=head;
        ListNode prev=dum;
        ListNode curr=dum.next;
        while(curr!=null)
        {
            ListNode curr2=curr;
            int len=0;
            while(curr!=null && curr.val==curr2.val)
            {
                curr=curr.next;
                len++;
            }
            if(len>1)
                prev.next=curr;
            else
                prev=prev.next;
        }
        return dum.next;
    }
}