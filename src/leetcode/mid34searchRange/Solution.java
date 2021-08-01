package leetcode.mid34searchRange;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int[] res={-1,-1};
        if(len<1)return res;
        int left=0,right=len,mid=0;
        while(left<right){
            mid=left+((right-left)>>1);
            if(nums[mid]==target){
                right=mid;
            }else if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }
        }
        if(left==len||nums[left]!=target)return res;
        res[0]=left;
        left=0;
        right=len;
        while(left<right){
            mid=left+((right-left)>>1);
            if(nums[mid]==target){
                left=mid+1;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        res[1]=left-1;
        return res;
    }

    public static void main(String[] args) {
        for (int i:searchRange(new int[]{2,2}, 3)             ) {
            System.out.println(i);
        }
    }
}