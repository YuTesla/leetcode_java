package leetcode.easy21mergeTwoSortedLists;

public class Solution {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode cur=node;
        ListNode lnode=l1;
        ListNode rnode=l2;
        while(lnode!=null||rnode!=null){
            if(lnode==null){
                cur.next=rnode;
                return node.next;
            }
            if(rnode==null){
                cur.next=lnode;
                return node.next;
            }
            if(lnode.val<rnode.val){
                cur.next=lnode;
                cur=cur.next;
                lnode=lnode.next;
            }else{
                cur.next=rnode;
                cur=cur.next;
                rnode=rnode.next;
            }
        }
        return node.next;
    }
}
