package leetcode.mid78subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

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
            path.addLast(nums[j]);
            dfs(nums,k,j+1,path,res);
            path.removeLast();
        }
    }
}
