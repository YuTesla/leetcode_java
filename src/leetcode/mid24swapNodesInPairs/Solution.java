package leetcode.mid24swapNodesInPairs;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        //1.迭代
        ListNode root=new ListNode(0);
        ListNode cur=root;
        ListNode left=head;
        if(left==null||left.next==null)return head;
        ListNode right=left.next;
        while(left!=null&&left.next!=null){
            cur.next=right;
            right.next=left;
            left=left.next;
            right=left.next;
            cur=left;
        }
        return root.next;

        //2.递归
//        if(head==null||head.next==null)return head;
//        ListNode tmp=head;
//        ListNode end=head.next;
//        tmp.next=swapPairs(end.next);
//        head=end;
//        end.next=tmp;
//
//        return head;
    }

    public static void main(String[] args) {
        Solution sou = new Solution();



    }
}
