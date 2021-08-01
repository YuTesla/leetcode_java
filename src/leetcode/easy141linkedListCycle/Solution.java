package leetcode.easy141linkedListCycle;

import java.util.HashSet;
import java.util.Set;

class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
public class Solution {
    public boolean hasCycle(ListNode head) {
        //1.使用Set
//        Set<ListNode> set=new HashSet<>();
//        while(head!=null){
//            if(set.contains(head))return true;
//            set.add(head);
//            head=head.next;
//        }
//        return false;

        //2.快慢指针
        if(head==null||head.next==null)return false;
        ListNode slow=head,fast=head.next.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow==fast;
    }
}