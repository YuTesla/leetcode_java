package MicroSoft.leader6_9;

class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val=val;
    }
}

public class Main {
    public static void main(String[] args) {

    }

    public static void insert(ListNode node,int val){
        if(node==null)return;
        ListNode cur=node;
        ListNode next_node=node.next;
//        if(next_node==cur){
//            ListNode insert_node=new ListNode(val);
//            node.next=insert_node;
//            insert_node.next=node;
//        }
        while(true){
            if(next_node==node){
                ListNode insert_node=new ListNode(val);
                cur.next=insert_node;
                insert_node.next=next_node;
                break;
            }
            if((cur.val<=val&&next_node.val>=val)||(next_node.val<cur.val&&(cur.val<=val||next_node.val>=val))){
                ListNode insert_node=new ListNode(val);
                cur.next=insert_node;
                insert_node.next=next_node;
                break;
            }
            cur=cur.next;
            next_node=next_node.next;

        }

    }
}
