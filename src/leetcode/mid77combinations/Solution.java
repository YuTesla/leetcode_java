package leetcode.mid77combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<1||n<k)return res;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,k,0,path,res);
        return res;
    }

    private void dfs(int[] nums,int k,int begin,Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝
        // for(int j=begin;j<nums.length-k+path.size()+1;j++){
        for(int j=begin;j<nums.length;j++){
            path.addLast(nums[j]);
            dfs(nums,k,j+1,path,res);
            path.removeLast();
        }
    }
}
