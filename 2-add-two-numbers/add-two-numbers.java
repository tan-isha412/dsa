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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null || curr2!=null)
        {
            int sum=0,carry=0,val=0;
            if(curr1==null)
            {
                sum=curr2.val+c;
                curr2=curr2.next;
            }   
            else if(curr2==null)
            {
                sum=curr1.val+c;
                curr1=curr1.next;
            }   
            else
            {
                sum=curr1.val+curr2.val+c;
                curr2=curr2.next;
                curr1=curr1.next;
            }   
            carry=sum/10;
            val=sum%10;
            curr.next=new ListNode(val);
            curr=curr.next;
            c=carry;
        }
        if(c>0)
            curr.next=new ListNode(c);
        return dummy.next;
    }
}