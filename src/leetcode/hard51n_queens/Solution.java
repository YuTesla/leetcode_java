package leetcode.hard51n_queens;

import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] place=new int[n];
        Arrays.fill(place,-1);
        Deque<String> path=new ArrayDeque<>();
        dfs(place,0,n,path,res);
        return res;
    }

    private void dfs(int[] place,int row,int n,Deque<String> path,List<List<String>> res){
        if(row==n){
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝思路1：在同一层使用相同的ifused
        boolean[] ifused = new boolean[n];
        Arrays.fill(ifused,true);
        for(int i=0;i<row;i++){
            ifused[place[i]]=false;
            if(place[i]+row-i<n)ifused[place[i]+row-i]=false;
            if(place[i]-row+i>=0)ifused[place[i]-row+i]=false;
        }
        char[] c = new char[n];
        Arrays.fill(c,'.');
        for(int j=0;j<n;j++){
            if(ifused[j]){
                c[j]='Q';
                path.addLast(new String(c));
                place[row]=j;
                System.out.println("递归之前"+path);
                dfs(place,row+1,n,path,res);
                place[row]=-1;
                path.removeLast();
                c[j]='.';
                System.out.println("递归之后"+path);
            }
        }
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        System.out.println(sou.solveNQueens(4));
    }
}
