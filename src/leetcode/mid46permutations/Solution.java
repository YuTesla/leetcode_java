package leetcode.mid46permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len = nums.length;
        if(len<1)return res;
        boolean[] used = new boolean[len];
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,used,path,res);
        return res;
    }

    private void dfs(int[] nums,boolean[] used,Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,used,path,res);
                path.removeLast();
                used[i]=false;
            }
        }
    }
}
