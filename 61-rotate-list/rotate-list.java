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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode curr=head;
        int len=1;
        while(curr.next!=null)
        {
            curr=curr.next;
            len++;
        }
        curr.next=head;
        k=k%len;
        k=len-k;
        for(int i=0;i<k;i++)
            curr=curr.next;
        ListNode newh=curr.next;
        curr.next=null;
        return newh;
    }
}