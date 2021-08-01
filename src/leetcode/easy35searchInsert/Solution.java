package leetcode.easy35searchInsert;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1,mid=0;
        while(lo<hi){
            mid=lo+((hi-lo)>>1);
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
}
