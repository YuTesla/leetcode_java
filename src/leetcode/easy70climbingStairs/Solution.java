package leetcode.easy70climbingStairs;

public class Solution {
    //1.暴力递归
//    public int climbStairs(int n) {
//        return dfs(n);
//    }
//
//    private int dfs(int rest){
//        if(rest==0||rest==1)return 1;
//        return dfs(rest-1)+dfs(rest-2);
//    }

    //2.改dp
    public int climbStairs(int n) {
        if (n == 1 || n == 0) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[n] = dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }
}
