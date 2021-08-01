package leetcode.mid142linkedListCycleii;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow=head,fast=head;
        while(fast!=null){
            if(fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode cur=head;
                while(slow!=cur){
                    slow=slow.next;
                    cur=cur.next;
                }
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        ListNode head=new ListNode(3);
        ListNode node=new ListNode(2);
        head.next=node;
        node.next=new ListNode(0);
        node.next.next=new ListNode(4);
        node.next.next.next=node;
        System.out.println(sou.detectCycle(head));
    }
}
