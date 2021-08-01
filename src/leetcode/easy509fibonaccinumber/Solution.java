package leetcode.easy509fibonacciNumber;

public class Solution {
    //1.暴力递归
//    public int fib(int n) {
//        if(n<1)return 0;
//        if(n==1||n==2)return 1;
//        else return fib(n-1)+fib(n-2);
//    }

    //2.带备忘录的递归——自顶向下
//    public int fib(int n) {
//        if(n<1)return 0;
//        int[] mem=new int[n+1];
//        return helper(n,mem);
//    }
//
//    private int helper(int n,int[] mem){
//        if(n==1||n==2)return 1;
//        else if(mem[n]!=0)return mem[n];
//        mem[n]=helper(n-1,mem)+helper(n-2,mem);
//        return mem[n];
//    }

    //3.dp——自底向上
    public int fib(int n) {
        if(n<1)return 0;
        if(n==1||n==2)return 1;
        int[] dp=new int[n+1];
        dp[1]=dp[2]=1;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
