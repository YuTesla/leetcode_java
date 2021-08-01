package TongHuaShun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class One {
    public static void main(String[] args) {
        String sen="Have a good day. Have a good class. Have a good visit. Have fun";
        Map<String,Integer> map=countAndSort(sen);
        String[] res=new String[map.size()];
        int i=0;
        for(String s:map.keySet()){
            res[i]=s;
            i++;
        }
        Arrays.sort(res,(o1,o2)->map.get(o2)-map.get(o1));
        for(String s: res){
            System.out.println(s+"出现了"+map.get(s)+"次");
        }
    }

    public static Map<String,Integer> countAndSort(String sen){
        Map<String,Integer> map=new HashMap<>();
        String[] ss=sen.split(" ");
        for(int i=0;i<ss.length;i++){
            if(ss[i].charAt(ss[i].length()-1)=='.')ss[i]=ss[i].substring(0,ss[i].length()-1);
        }
        for(String s:ss){
            if(s.length()!=0&&s.charAt(0)!=' '){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        return map;
    }

}
