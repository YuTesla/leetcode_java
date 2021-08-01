package Third.mid31nextPermutation_;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        // 11223344
        // 11224433
        // 112244333
        // 112244433
        // 125123
        // 65123
        // 654312
        // 654321
        int n=nums.length;
        if(n<2)return;
        int index=n-2;
        while(index>=0){
            if(nums[index+1]>nums[index]){
                for(int i=n-1;i>index;i--){
                    if(nums[i]>nums[index]){
                        swap(nums,i,index);
                        Arrays.sort(nums,index+1,n);
                        return;
                    }
                }
            }
            index--;
        }


        for(int i=0;i<n/2;i++){
            swap(nums,i,n-i-1);
        }

    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
