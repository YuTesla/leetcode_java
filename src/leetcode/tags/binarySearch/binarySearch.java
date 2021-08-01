package leetcode.tags.binarySearch;

public class binarySearch {
    public static int singlenum(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int leftbound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;              //$$$$$$$$$$$$$$$$$$$
        int mid = 0;
        while (left < right) {                  //$$$$$$$$$$$$$$$$$$$
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                right = mid;                  //$$$$$$$$$$$$$$$$$$$
            else if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;                 //$$$$$$$$$$$$$$$$$$$
        }
        return nums[left] == target ? left : -1;                        //$$$$$$$$$$$$$$$$$$$
    }

    public static int rightbound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums1={0,0,1,2,2,5,6};
        int target1=2;
        System.out.println(singlenum(nums1,target1));

        int[] nums2 = {1};
        int target2 = 1;
        System.out.println(leftbound(nums2, target2));

        int[] nums3 = {1};
        int target3 = 1;
        System.out.println(rightbound(nums3, target3));
    }
}
