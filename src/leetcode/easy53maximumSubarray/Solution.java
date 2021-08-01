package leetcode.easy53maximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        //1.二维暴力dp——超出内存限制
//        int len=nums.length;
//        if(len<2)return nums[0];
//        int[][] sums=new int[len][len];
//        for(int i=0;i<len;i++){
//            sums[i][i]=nums[i];
//        }
//        for(int i=0;i<len-1;i++){
//            for(int j=i+1;j<len;j++){
//                sums[i][j]=sums[i][j-1]+sums[j][j];
//            }
//        }
//        int res=Integer.MIN_VALUE;
//        for(int i=0;i<len;i++){
//            for(int j=i;j<len;j++){
//                res=Math.max(res,sums[i][j]);
//            }
//        }
//        return res;

    //2.有技巧的暴力
//        int len=nums.length;
//        if(len<2)return nums[0];
//        int res=Integer.MIN_VALUE;
//        for(int i=0;i<len;i++){
//            int max=0;
//            for(int j=i;j<len;j++){
//                max+=nums[j];
//                res=Math.max(res,max);
//                if(max<0)break;
//            }
//        }
//        return res;

        //3.题解的一维dp
        int len=nums.length;
        if(len<2)return nums[0];
        int[] dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            res=Math.max(res,dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
