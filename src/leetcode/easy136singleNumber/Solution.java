package leetcode.easy136singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        //1.时间O(N),空间O(N)
//        Map<Integer,Integer> map=new HashMap<>();
//        for(int i:nums){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        int res=0;
//        for(int i:map.keySet()){
//            if(map.get(i)==1)res=i;
//        }
//        return res;

        //2.位运算
        int res=0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }
}
