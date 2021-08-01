package leetcode.utils.list;


public class List_ {
    public ListNode root=null;
    public List_(){};
    public List_(String listStr){
        String[] strs=listStr.substring(1,listStr.length()-1).split(",");
        ListNode[] listList=new ListNode[strs.length];
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("null")){
                listList[i]=null;
            }else {
                listList[i]=new ListNode(Integer.parseInt(strs[i]));
            }
        }

        if(listList.length<1)return;
        root=listList[0];
        ListNode cur=root;
        for(int i=1;i<listList.length;i++){
            cur.next=listList[i];
            cur=cur.next;
        }
        return;
    }

    public static void print(ListNode root){
        if(root==null)return;
        System.out.println(root.val);
        print(root.next);
    }

    public static void main(String[] args) {
        List_.print(new List_("[1,2,3,4]").root);
    }
}
