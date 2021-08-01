package leetcode.mid5longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int len=s.length();
        for(int i=0;i<len;i++){
            String ans1=f(s,i,0,0,len);
            if(ans1.length()>res.length())res=ans1;
            String ans2=f(s,i,0,1,len);
            if(ans2.length()>res.length())res=ans2;
        }
        return res;
    }

    private String f(String s,int center,int offset,int doubleoffset,int len){
        if(center+offset>=len||center-offset+doubleoffset<0||center-offset+doubleoffset>=len||s.charAt(center+offset)!=s.charAt(center-offset+doubleoffset)){
            return "";
        }else if(s.charAt(center+offset)==s.charAt(center-offset+doubleoffset)){
            String ans = f(s,center,offset+1,doubleoffset,len);
            System.out.println(ans+s.charAt(center+offset)+"   center="+center+"doubleoffset="+doubleoffset);
            return (doubleoffset==1&&offset==0)?ans+ans:ans+s.charAt(center+offset)+ans;
        }
        return "";
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        System.out.println(sou.longestPalindrome("cbbd"));
    }
}
