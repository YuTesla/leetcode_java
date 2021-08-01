package leetcode.mid152maximumProductSubarray;

public class Solution {
    public static int maxProduct(int[] nums) {
        if(nums.length==0)return -1;
        int maxnum=nums[0],minnum=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=Math.max(nums[i],Math.max(maxnum*nums[i],minnum*nums[i]));
            minnum=Math.min(nums[i],Math.min(maxnum*nums[i],minnum*nums[i]));
            maxnum=tmp;
            res=Math.max(res,maxnum);
        }
        return res;
    }

    public static void main(String[] args) {
        maxProduct(new int[]{-4,-3,-2});
    }
}