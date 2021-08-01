package leetcode.easy283moveZeroes;

public class Solution {
    //1.类似插入排序
//    public void moveZeroes(int[] nums) {
//        int n=nums.length;
//        if(n<2)return;
//        for(int i=0;i<n-1;i++){
//            for(int j=i+1;j>0&&nums[j-1]==0&&nums[j]!=0;j--){
//                swap(nums,j,j-1);
//            }
//        }
//        return;
//    }
//
//    public void swap(int[] arr,int i,int j){
//        int tmp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=tmp;
//    }
    //2.双指针
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n<2)return;
        int fast=0,slow=0;
        for(slow=0;slow<n;slow++){
            while(fast<n){
                if(nums[fast]!=0)break;
                fast++;
            }
            if(fast==n)break;
            nums[slow]=nums[fast];
            fast++;
        }
        for(;slow<n;slow++){
            nums[slow]=0;
        }
    }
}
