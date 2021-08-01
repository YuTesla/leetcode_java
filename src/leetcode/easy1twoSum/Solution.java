package leetcode.easy1twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> nummap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nummap.containsKey(target-nums[i]))return new int[]{i,nummap.get(target-nums[i])};
            nummap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
