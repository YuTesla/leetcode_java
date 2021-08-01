package leetcode.hard41firstMissingPositive_;

public class Solution {
//    public static int firstMissingPositive(int[] nums) {
//        int len=nums.length;
//        for(int i=0;i<len;i++){
//            if(nums[i]<=0)nums[i]=len+1;
//        }
//        for(int j=0;j<len;j++){
//            if(Math.abs(nums[j])<=len&&nums[Math.abs(nums[j])-1]>0)nums[Math.abs(nums[j])-1]*=-1;
//        }
//        for(int k=0;k<len;k++){
//            if(nums[k]>0)return k+1;
//        }
//        return len+1;
//
//
//    }

    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]-1<nums.length&&nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return nums.length+1;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
