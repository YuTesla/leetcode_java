package often;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf36 {
    Character[] nums = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    List<Character> l= Arrays.asList(nums);
    public static void main(String[] args) {


    }

    public String to36(int num){
        StringBuffer sb=new StringBuffer();
        while(num!=0){
            sb.append(l.get(num%36));
            num=num/36;
        }
        return sb.reverse().toString();
    }

    public int to10(String str){
        char[] cs=str.toCharArray();
        int res=0;
        for(int i=0;i< cs.length;i++){
            res+=Math.pow(36,i)* l.indexOf(cs[cs.length-i-1]);
        }
        return res;
    }


}
