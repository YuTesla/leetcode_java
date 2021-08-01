package leetcode.mid49groupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1.HashMap
        Map<String,List<String>> smap=new HashMap<>();
        for(String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String key=new String(c);
            List<String> ans;


            if(!smap.containsKey(key)){
                ans=new ArrayList<>();
            }else{
                ans=smap.get(key);
            }
            //改进版
            //ans=smap.getOrDefault(key,new ArrayList<>());

            ans.add(str);
            smap.put(key,ans);

        }
        return new ArrayList<List<String>>(smap.values());
    }
}
