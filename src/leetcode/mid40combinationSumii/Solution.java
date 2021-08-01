package leetcode.mid40combinationSumii;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, res);
        return res;
    }
    private void dfs(int[] can,int tar,int begin,Deque<Integer> path,List<List<Integer>> res) {
        if (tar == 0) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            for (int i = begin; i < can.length; i++) {
                if(tar-can[i]<0) {
                    break;
                }
                path.add(can[i]);
                dfs(can, tar - can[i], begin++, path, res);
                path.removeLast();
            }

        }
    }
}
