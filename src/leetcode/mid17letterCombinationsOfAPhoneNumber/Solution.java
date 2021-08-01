package leetcode.mid17letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //1.回溯（使用String 6ms）
    private String[] map={
            "",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9
    };
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        dfs(digits,0,"",res);
        return res;
    }
    private void dfs(String digits,int index,String ans,List<String> res){
        if(index==digits.length()){
            res.add(new String(ans));
            return;
        }
        String letters=map[digits.charAt(index)-'0'];
        int len=letters.length();
        for(int i=0;i<len;i++){
            dfs(digits,index+1,ans+letters.charAt(i),res);
        }
    }

    //2.回溯（使用StringBuffer 1ms 就尼玛的离谱）
//    public List<String> letterCombinations(String digits) {
//        List<String> res=new ArrayList<>();
//        if("".equals(digits))return res;
//        dfs(digits,0,new StringBuffer(),res);
//        return res;
//    }
//    private void dfs(String digits,int index,StringBuffer ans,List<String> res){
//        if(index==digits.length()){
//            res.add(new String(ans));
//            return;
//        }
//        String letters=map.get(digits.charAt(index));
//        int len=letters.length();
//        for(int i=0;i<len;i++){
//            ans.append(letters.charAt(i));
//            dfs(digits,index+1,ans,res);
//            ans.deleteCharAt(index);
//        }
//    }
}
