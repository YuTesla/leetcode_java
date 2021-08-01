package leetcode.mid90subsetsii;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length+1;i++){
            dfs(nums,i,0,path,res);
        }
        return res;
    }

    private void dfs(int[] nums,int k,int begin,Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j=begin;j<nums.length-k+path.size()+1;j++){
            if(j>begin&&nums[j]==nums[j-1])continue;
            path.addLast(nums[j]);
            dfs(nums,k,j+1,path,res);
            path.removeLast();
        }
    }
}
