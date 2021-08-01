package leetcode.utils.Binsearch;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(binSearch(new int[] {1,3,5,8,9},0,4,1));
        System.out.println(findMinIndex(new int[]{4,5,6,7,0,1,2}));
    }


    public static int binSearch(int[] nums,int l,int r,int target){
        while(l<r){
            int m=((r-l)>>1)+l;
            if(target>nums[m]){
                l=m+1;
            }else if(target<nums[m]){
                r=m-1;
            }else{
                return m;
            }
        }
        return nums[l]==target?l:-1;
    }

    public static int findMinIndex(int numbers[]){
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return low;
    }
}
