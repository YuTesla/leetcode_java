package leetcode;



import leetcode.utils.tree.Tree;
import leetcode.utils.tree.TreeNode;

public class Mirros {
    public static void mirros(TreeNode root){
        if(root==null)return;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                cur=cur.right;
                //先序遍历&&中序遍历   没有左子树，第一次访问和第二次访问节点合并成一次
//                System.out.println(cur.val);
            }else{
                TreeNode mostright=cur.left;
                while(mostright.right!=null&&mostright.right!=cur){
                    mostright=mostright.right;
                }
                if(mostright.right==null){
                    //先序遍历
//                    System.out.println(cur.val);
                    mostright.right=cur;
                    cur=cur.left;
                }else{
                    //中序遍历
//                    System.out.println(cur.val);
                    mostright.right=null;
                    cur=cur.right;
                }
            }

        }
    }

    public static void main(String[] args) {
//        mirros(new Tree("[1,2,3,4,5,6]").root);
    }
}
