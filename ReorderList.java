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
        //1.find the middle node and break it.
        //2.reverse the second part
        //3.merge according to it.

        //1.middle node and break
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //midpoint=slow
        ListNode temp=slow.next;
        slow.next=null;
        //2.reverse
        ListNode prev=null;
        ListNode curr=temp;
        while(curr!=null)
        {
            ListNode next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        }
        //3.merge
        ListNode first=head;
        ListNode second=prev;
        while(second!=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;   
        }
        
    }
}
