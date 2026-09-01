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
        ListNode small=new ListNode(-1);
        ListNode great=new ListNode(-2);
        ListNode curr1=small;
        ListNode curr2=great;
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                curr1.next=curr;
                curr1=curr1.next;
            }
            else
            {
                curr2.next=curr;
                curr2=curr2.next;
            }
            curr=curr.next;
        }
        curr2.next=null;
        curr1.next=great.next;
        return small.next;
    }
}