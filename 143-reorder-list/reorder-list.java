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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=slow;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode last=rev(slow);
        slow.next=null;
        fast=head;
        ListNode save=last;
        ListNode next;
        while(last.next!=null)
        {
            next=fast.next;
            fast.next=save;
            save=last.next;
            last.next=next;
            fast=next;
            last=save;
        }
        return ;
    }
    public ListNode rev(ListNode head)
    {
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}