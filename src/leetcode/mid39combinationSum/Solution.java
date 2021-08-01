package leetcode.mid39combinationSum;


import java.util.*;

public class Solution {
    //1.官方回溯
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int len = candidates.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(candidates, 0, len, target, path, res);
//        return res;
//    }
//
//    /**
//     * @param candidates 候选数组
//     * @param begin      搜索起点
//     * @param len        冗余变量，是 candidates 里的属性，可以不传
//     * @param target     每减去一个元素，目标值变小
//     * @param path       从根结点到叶子结点的路径，是一个栈
//     * @param res        结果集列表
//     */
//    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
//        // target 为负数和 0 的时候不再产生新的孩子结点
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        // 重点理解这里从 begin 开始搜索的语意
//        for (int i = begin; i < len; i++) {
//            path.addLast(candidates[i]);
//
//            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
//            dfs(candidates, i, len, target - candidates[i], path, res);
//
//            // 状态重置
//            path.removeLast();
//        }
//    }
    //2.无剪枝回溯
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }
        private static void dfs(int[] can,int tar,int begin,Deque<Integer> path,List<List<Integer>> res) {
            if (tar == 0) {
                res.add(new ArrayList<>(path));
                return;
            } else if (tar < 0) {
                return;
            } else {
                for (int i = begin; i < can.length; i++) {
                    path.add(can[i]);
                    System.out.println("递归之前是"+path+" 剩余"+(tar-can[i]));
                    dfs(can, tar - can[i], ++begin, path, res);
                    path.removeLast();
                    System.out.println("递归之后是"+path);
                }

            }
        }
    //3.含剪枝回溯
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int len = candidates.length;
//        Deque<Integer> path = new ArrayDeque<>();
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
//        dfs(candidates, target, 0, path, res);
//        return res;
//    }
//    private static void dfs(int[] can,int tar,int begin,Deque<Integer> path,List<List<Integer>> res) {
//        if (tar == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        } else {
//            for (int i = begin; i < can.length; i++) {
//                if(tar-can[i]<0) {
//                    break;
//                }
//                path.add(can[i]);
//                dfs(can, tar - can[i], begin++, path, res);
//                System.out.println("递归之前是"+path+" 剩余"+(tar-can[i]));
//                path.removeLast();
//                System.out.println("递归之后是"+path);
//            }
//
//        }
//    }


    public static void main(String[] args) {
        int[] con={2,3,6,7};
        combinationSum(con,7);
    }
}
