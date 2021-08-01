package leetcode.utils.tree;

import java.util.*;

public class Tree {
    public TreeNode root=new TreeNode();
    public static int index;
    public Tree(){}
    public Tree(String treeStr){
        //生成以treeStr为val的TreeNode数组
        String[] strs=treeStr.substring(1,treeStr.length()-1).split(",");
        TreeNode[] treeList=new TreeNode[strs.length];
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("null")){
                treeList[i]=null;
            }else {
                treeList[i]=new TreeNode(Integer.parseInt(strs[i]));
            }
        }

        if(treeList.length<1)return;
        Deque<TreeNode> q=new ArrayDeque<>();
        int index=0;
        root=treeList[0];
        q.offer(root);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz&&index<treeList.length;i++){
                TreeNode node=q.poll();
                if(++index<treeList.length){
                    node.left=treeList[index];
                    if(node.left!=null)q.offer(node.left);
                }
                if(++index<treeList.length){
                    node.right=treeList[index];
                    if(node.right!=null)q.offer(node.right);
                }
            }
            if(index>=treeList.length)break;
        }
        return;
    }

    public static void preTree(TreeNode root){
        //1.递归
//        if(root==null)return;
//        System.out.println(root.val);
//        preTree(root.left);
//        preTree(root.right);
        //2.栈
        if(root==null)return;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int sz=stack.size();
            for(int i=0;i<sz;i++){
                TreeNode node=stack.pop();
                System.out.println(node.val);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }

    }

    public static void midTree(TreeNode root){
        //1.递归
//        if(root==null)return;
//        midTree(root.left);
//        System.out.println(root.val);
//        midTree(root.right);
        //2.栈
        if(root==null)return;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        TreeNode head=root.left;
        while(!stack.isEmpty()||head!=null) {
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else{
                TreeNode node=stack.pop();
                System.out.println(node.val);
                head=node.right;
            }
        }
    }

    public static void postTree(TreeNode root){
        //1.递归
//        if(root==null)return;
//        postTree(root.left);
//        postTree(root.right);
//        System.out.println(root.val);
        //2.栈
        if(root==null)return;
        Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<TreeNode> ans=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int sz=stack.size();
            for(int i=0;i<sz;i++){
                TreeNode node=stack.pop();
                ans.push(node);
                if(node.left!=null){
                    stack.push(node.left);
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
            }
        }
        while(!ans.isEmpty()) System.out.println(ans.pop().val);
    }

    public static void bfsTree(TreeNode root){
        if(root==null)return;
        System.out.println(root.val);
        bfsTree(root.left);
        bfsTree(root.right);
    }

    public static void printTree(TreeNode root){
        if(root==null)return;
//        Deque<TreeNode> q=new ArrayDeque<>();
        //?????????????????????????????????????arrayDeque不能加null但是linkedList可以
        Deque<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean allnull=false;
        while(!q.isEmpty()&&!allnull){
            int sz=q.size();
            allnull=true;
            for(int i=0;i<sz;i++){
                TreeNode node=q.poll();
                if(node==null){
                    System.out.print("\t");
                    continue;
                }
                System.out.printf("%d\t",node.val);
                if(node.left!=null||node.right!=null)allnull=false;
                q.offer(node.left);
                q.offer(node.right);
            }
            System.out.println();

        }

    }

    public static void printTree(String treeStr){
        String[] strs=treeStr.substring(1,treeStr.length()-1).split(",");

    }

    public static String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuffer sb=new StringBuffer();
        dfs(root,sb);
        return new String(sb);
    }
    public static void dfs(TreeNode node,StringBuffer sb){
        if(node==null){
            sb.append("#_");
            return;
        }
        sb.append(String.valueOf(node.val)).append("_");
        dfs(node.left,sb);
        dfs(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        String[] str=data.split("_");
        index=0;
        return anti_dfs(str);
    }
    public static TreeNode anti_dfs(String[] str){
        if(index==str.length)return null;
        if(str[index].equals("#")){
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(str[index]));
        index++;
        node.left=anti_dfs(str);
        node.right=anti_dfs(str);
        return node;
    }

    public static void main(String[] args) {
//        Tree.preTree(new Tree("[1,2,3,4,5,null,7,8,null,null,9]").root);
//        Tree.midTree(new Tree("[1,2,3,4,5,null,7,8,null,null,9]").root);
//        Tree.postTree(new Tree("[1,2,3,4,5,null,7,8,null,null,9]").root);
//        Tree.printTree(new Tree("[1,2,3,4,5,null,7,8,null,null,9]").root);
        System.out.println(Tree.serialize(new Tree("[1,2,3,4,5,null,7,8,null,null,9]").root));
    }
}
