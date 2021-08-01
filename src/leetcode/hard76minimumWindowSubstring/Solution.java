package leetcode.hard76minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Character,Integer> tmap=new HashMap<>();
    Map<Character,Integer> smap=new HashMap<>();

    public String minWindow(String s, String t) {

        int left=0,right=0;
        char[] tcs=t.toCharArray();
        for(char c:tcs){
            int num=tmap.getOrDefault(c,0);
            tmap.put(c,num+1);
        }
        int len=Integer.MAX_VALUE;
        int[] ans=new int[2];
        while(right<=s.length()){
            if(check()){
                if(right-left<len){
                    ans[0]=left;
                    ans[1]=right;
                    len=right-left;
                }
                smap.put(s.charAt(left),smap.getOrDefault(s.charAt(left++),0)-1);
            }else{
                if(right==s.length())break;
                smap.put(s.charAt(right),smap.getOrDefault(s.charAt(right++),0)+1);
            }
        }
        return s.substring(ans[0],ans[1]);
    }

    private boolean check(){
        for(char c:tmap.keySet()){
            if(tmap.get(c)>smap.getOrDefault(c,0))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sou = new Solution();
        sou.minWindow("cabwefgewcwaefgcf",
                "cae");
    }
}
