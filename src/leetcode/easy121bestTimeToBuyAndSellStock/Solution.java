package leetcode.easy121bestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        //1.暴力
//        int res=0;
//        for(int i=0;i<prices.length;i++){
//            for(int j=i+1;j<prices.length;j++){
//                res=Math.max(res,prices[j]-prices[i]);
//            }
//        }
//        return res;

        //2.从后往前遍历
        int res=0;
        int min=prices[0];
        for(int j=1;j<prices.length;j++){
            min=Math.min(min,prices[j-1]);
            res=Math.max(res,prices[j]-min);
        }
        return res;


    }
}
