package MicroSoft.first6_3;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
    double val;
    TreeNode left;
    TreeNode right;
    boolean ifright;
    TreeNode(){}
    TreeNode(double val){
        this.val=val;
    }
    TreeNode(double val,boolean ifright){
        this.val=val;
        this.ifright=ifright;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);
        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(3);
        root2.right=new TreeNode(4);

//        TreeNode node=dfs(root1,root2,false);

        if(root1==null||root2==null)return;
        Deque<TreeNode> stack1=new LinkedList<>();
        Deque<TreeNode> stack2=new LinkedList<>();
//        double[] value_soft_root=softmax(root1.val, root2.val);
//        double value_root=value_soft_root[0];
//        TreeNode root=new TreeNode(value_root);
        stack1.push(root1);
        stack2.push(root2);
        TreeNode pre=null;
        TreeNode root=null;
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            TreeNode node_left=stack1.pop();
            TreeNode node_right=stack2.pop();
            double[] value_soft=softmax(root1.val, root2.val);
            double value=root1.ifright?value_soft[1]:value_soft[0];

            TreeNode node=new TreeNode(value,root1.ifright);
            if(pre==null)root=node;
            else{

                pre=node;
            }
            if(root1.left!=null&&root2.left!=null){
                root1.left.ifright=false;
                root2.left.ifright=false;
                stack1.push(root1.left);
                stack2.push(root2.left);
            }
            if(root1.right!=null&&root2.right!=null){
                root1.right.ifright=true;
                root2.right.ifright=true;
                stack1.push(root1.right);
                stack2.push(root2.right);
            }
        }

        return;


    }

//    public static TreeNode dfs(TreeNode root1,TreeNode root2,boolean ifright){
//        if(root1==null||root2==null)return null;
//
//        double[] value_soft=softmax(root1.val, root2.val);
//        double value=ifright?value_soft[1]:value_soft[0];
//
//        TreeNode node=new TreeNode(value);
//        if(root1.left!=null&&root2.left!=null){
//            node.left=dfs(root1.left,root2.left,false);
//        }
//        if(root1.right!=null&&root2.right!=null){
//            node.right=dfs(root1.right,root2.right,true);
//        }
//        return node;
//    }

    public static double[] softmax(double x,double y){
        double fenmu=Math.exp(x)+Math.exp(y);
        double ans1=Math.exp(x);
        double ans2=Math.exp(y);
        return new double[]{ans1/fenmu,ans2/fenmu};
    }
}
