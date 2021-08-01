package leetcode.mid322coinChange;

public class Solution {
    //1.自己想的dp
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0)return 0;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,-1);
//        for(int i=0;i<coins.length;i++){
//            if(coins[i]<amount+1)dp[coins[i]]=1;
//        }
//        for(int i=1;i<amount+1;i++){
//            if(dp[i]==-1){
//                int left=1;
//                int right=i-1;
//                int tmp=9999;
//                while(left<=right){
//                    if(dp[left]>0&&dp[right]>0){
//                        tmp=Math.min(tmp,dp[left]+dp[right]);
//                    }
//                    left++;
//                    right--;
//                }
//                if(tmp<9999)dp[i]=tmp;
//            }
//        }
//        return dp[amount];
//    }

    //2.强行递归（超时）
//    int res = Integer.MAX_VALUE;
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0)return 0;
//        dfs(coins,amount,0);
//        if(res<Integer.MAX_VALUE)return res;
//        else return -1;
//    }
//
//    private void dfs(int[] coins,int amount,int num){
//        if(amount==0)res=Math.min(num,res);
//        if(amount<0)return;
//        for(int i=0;i<coins.length;i++){
//            dfs(coins,amount-coins[i],num+1);
//        }
//    }

    //3.记忆化搜索
//    int[] mem;
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0)return 0;
//        mem=new int[amount+1];
//        dfs(coins,amount);
//        return mem[amount];
//    }
//
//    private int dfs(int[] coins,int amount){
//        if(amount==0)return 0;
//        if(amount<0)return -1;
//        if(mem[amount]!=0)return mem[amount];
//        int res=Integer.MAX_VALUE;
//        for(int i=0;i<coins.length;i++){
//            int num=dfs(coins,amount-coins[i]);
//            if(num>=0&&num<res)res=num+1;
//        }
//        mem[amount]=(res<Integer.MAX_VALUE?res:-1);
//        return mem[amount];
//    }

     //4.dp
     public int coinChange(int[] coins, int amount) {
         if(amount==0)return 0;
         int[] dp=new int[amount+1];
         int len=coins.length;
         for(int i=1;i<amount+1;i++){
             int min=Integer.MAX_VALUE;
             for(int j=0;j<len;j++){
                 if(i-coins[j]>=0&&dp[i-coins[j]]>=0)min=Math.min(min,dp[i-coins[j]]+1);
             }
             dp[i]=(min==Integer.MAX_VALUE?-1:min);
         }
         return dp[amount];
     }

    public static void main(String[] args) {
        Solution sou=new Solution();
        System.out.println(sou.coinChange(new int[]{1,2,5},11));
    }
}
