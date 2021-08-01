package Third.easy121bestTimeToBuyAndSellStock_;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] maxw=new int[prices.length];
        maxw[0]=0;
        int minw=Integer.MAX_VALUE;
        for(int i=1;i<prices.length;i++){
            minw=Math.min(minw,prices[i-1]);
            maxw[i]=prices[i]-minw;
        }
        int res=Integer.MIN_VALUE;
        for(int w:maxw){
            res=Math.max(res,w);
        }
        return res;
    }
}
