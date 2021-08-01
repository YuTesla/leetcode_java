package leetcode.mid95uniqueBinarySearchTreesii_;


import leetcode.utils.tree.Tree;
import leetcode.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode> res=new ArrayList<>();
//        if(n==0)return res;
//        res=backtrack(1,n);
//        return res;
//    }
//
//    private List<TreeNode> backtrack(int start,int end){
//        List<TreeNode> res=new ArrayList<TreeNode>();
//        if(start>=end)return null;
//        for(int i=start;i<=end;i++){
//            List<TreeNode> left=backtrack(start,i-1);
//            List<TreeNode> right=backtrack(i+1,end);
//            for(TreeNode leftnode:left){
//                for(TreeNode rightnode:right){
//                    TreeNode node=new TreeNode(i);
//                    node.left=leftnode;
//                    node.right=rightnode;
//                    res.add(node);
//                }
//            }
//        }
//        return res;
//    }

    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dp=new ArrayList<>();
        List<TreeNode> zero=new ArrayList<>();
        zero.add(null);
        dp.add(zero);
        List<TreeNode> one=new ArrayList<>();
        one.add(new TreeNode(1));
        dp.add(one);
        for(int i=2;i<=n;i++){
            List<TreeNode> trees=new ArrayList<>();
            for(int rootnum=1;rootnum<=i;rootnum++){
                int leftnums=rootnum-1;
                int rightnums=i-leftnums-1;
                for(TreeNode l:dp.get(leftnums)){
                    for(TreeNode r:dp.get(rightnums)){
                        TreeNode node=new TreeNode(rootnum);
                        node.left=l;
                        node.right=clone(r,rootnum);
                        trees.add(node);
                    }
                }

            }
            dp.add(trees);
        }
        return dp.get(n);
    }

    private TreeNode clone(TreeNode root,int offset){
        if(root==null)return root;
        root.left=clone(root.left,offset);
        root=new TreeNode(root.val+offset);
        root.right=clone(root.right,offset);
        return root;
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        Tree.midTree(sou.generateTrees(2).get(1));
    }

}
