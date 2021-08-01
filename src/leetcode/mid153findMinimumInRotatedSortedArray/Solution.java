package leetcode.mid153findMinimumInRotatedSortedArray;

public class Solution {
    public static int findMin(int[] nums) {
        int len=nums.length;
        if(len==1||nums[0]<nums[len-1])return nums[0];
        int left=0,right=len-1,mid=0;
        while(left<=right){
            mid=left+((right-left)>>1);
            if(mid>0&&nums[mid]<nums[mid-1])return nums[mid];
            if(nums[mid]<nums[right]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
