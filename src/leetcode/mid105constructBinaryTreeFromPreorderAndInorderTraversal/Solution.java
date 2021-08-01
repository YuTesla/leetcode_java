package leetcode.mid105constructBinaryTreeFromPreorderAndInorderTraversal;

import leetcode.utils.tree.TreeNode;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public static int indexof(int[] arr,int num){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                res=i;
                break;
            }
        }
        return res;
    }

    public static TreeNode buildTree(int[] preorder,int[] inorder,int pstart,int pend,int istart,int iend){
        if(pend-pstart<0||pstart>=preorder.length||istart>=preorder.length)return null;
        TreeNode root=new TreeNode(preorder[pstart]);
        if(pend==pstart)return root;
        int index=indexof(inorder,preorder[pstart]);
        int rightnodenum=iend-index;
        int leftnodenum=index-istart;
        root.left=buildTree(preorder,inorder,pstart+1,pstart+leftnodenum,istart,istart+leftnodenum-1);
        root.right=buildTree(preorder,inorder,pstart+leftnodenum+1,pstart+leftnodenum+rightnodenum,index+1,index+rightnodenum);
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}