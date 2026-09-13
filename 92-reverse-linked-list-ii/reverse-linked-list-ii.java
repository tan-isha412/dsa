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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode before=dummy;
        for(int i=1;i<left;i++)
            before=before.next;
        int num=right-left;
        ListNode prevn=null;
        ListNode nextn=null;
        ListNode currn=before.next;
        ListNode tail=currn;
        while(num>=0)
        {
            nextn=currn.next;
            currn.next=prevn;
            prevn=currn;
            currn=nextn;
            num--;
        }
        before.next=prevn;
        tail.next=currn;
        return dummy.next;
    }
}