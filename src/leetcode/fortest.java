package leetcode;

import leetcode.mid24swapNodesInPairs.Solution;

import java.util.*;

public class fortest {
    public static void main(String[] args) {
//        System.out.println(3+(2>>1));
//        boolean[] res=new boolean[4];
//        System.out.println(res[2]);

//        Deque<Integer> res=new ArrayDeque<>();
//        res.add(2);
//        res.add(3);
//        System.out.println(res.size());

//        int[] place=new int[5];
//        Arrays.fill(place,-1);
//        System.out.println(place[4]);

//        for(int i=1;i>1;i--){
//            System.out.println("11");
//        }

//        String [][] dp=new String[1][2];
//        for(String[] st:dp){
//            for(String s:st)
//                System.out.println(s==null);
//        }
//        String str="xxsxsds";
//        System.out.println(str.substring(2,5));

//        String tmp="123";
//        char a=tmp.charAt(2);
//        System.out.println((int)'2');
//        String tmp="ab";
//        String tmp2="ab"+"vd";
//        System.out.println(tmp2);

//        for(int i=3;i>=0;i--) System.out.println(i);

//        String ans="124";
//        System.out.printf("%d",Integer.parseInt(ans));

//        Set<String> data=new HashSet<>();
//        data.add("123");
//        data.add("21s");
//        for(String s:data){
//            System.out.println(s);
//        }

//        String s="1_2_#_4";
//        String[] c=s.split("_");
//        for(String ss:c) System.out.println(ss);

//        String[] str="11100110111000001".split("0");
//        for(String s:str) System.out.println(s);

//        Scanner sc=new Scanner(System.in);
//        sc.hasNextLine();

        Map<Integer, Node> map=new HashMap<>();
        map.put(1,new Node(10));
        System.out.println(map.get(1).val);
        map.get(1).val=1;
        System.out.println(map.get(1).val);

    }

}
class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}
