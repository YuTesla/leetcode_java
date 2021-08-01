package leetcode.mid33searchInRotatedSortedArray__;
//边界条件

class Solution {

    public static int search(int[] nums, int target) {
        //1.暴力，不用题设条件
//        for(int i=0;i<nums.length;i++){
//            if(target==nums[i]){
//                return i;
//            }
//        }
//        return -1;
        int lo=0;
        int hi=nums.length-1;
        int mid=0;
        while(lo<=hi){
            mid=lo+(hi-lo)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>=nums[lo]){
                if(target>=nums[lo]&&nums[mid]>target){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1},0));
    }
}