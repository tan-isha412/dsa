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
    public ListNode partition(ListNode head, int x) {
        ListNode dum1=new ListNode(-101);
        ListNode c1=dum1;
        ListNode dum2=new ListNode(-101);
        ListNode c2=dum2;
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                dum1.next=curr;
                dum1=dum1.next;
            }
            else
            {
                dum2.next=curr;
                dum2=dum2.next;
            }
            curr=curr.next;
        }
        dum2.next=null;
        dum1.next=c2.next;
        return c1.next;
    }
}