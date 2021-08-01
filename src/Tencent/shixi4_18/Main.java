package Tencent.shixi4_18;

import java.util.Arrays;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int Q = sc.nextInt();
//        triTree tree=new triTree();
//
//        for(int i = 0; i < n; i++){
//            String data=sc.next();
//            tree.add(data);
//        }
//
//        for(int i = 0; i < Q; i++){
//            String data_find=sc.next();
//            int[] res=tree.findSim(data_find);
//            System.out.printf("%d %d\n",res[0],res[1]);
//        }
//
//    }
//
//    public static class triTree{
//        public class Node{
//            public Node[] next=new Node[10];
//            public int count=0;
//            public Node(){}
//        }
//        public Node root=new Node();
//
//        public void add(String nums){
//            char[] str=nums.toCharArray();
//            Node cur=root;
//            for(int i=0;i<str.length;i++){
//                if(cur.next[str[i]-'0']==null){
//                    cur.next[str[i]-'0']=new Node();
//                }
//                cur.count++;
//                cur=cur.next[str[i]-'0'];
//            }
//        }
//
//        public int[] findSim(String nums){
//            int[] res=new int[2];
//            char[] str=nums.toCharArray();
//            Node cur=root;
//            for(int i=0;i<str.length;i++){
//                if(cur.next[str[i]-'0']==null){
//                    res[0]=i;
//                    res[1]=cur.count;
//                    break;
//                }
//                cur=cur.next[str[i]-'0'];
//            }
//            return res;
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        hunter[] hs_sort=new hunter[n];
        hunter[] hs=new hunter[n];

        for(int i = 0; i < n; i++){
            int att=sc.nextInt();
            hs_sort[i]=new hunter();
            hs_sort[i].attack=att;
            hs[i]=new hunter();
            hs[i].attack=att;
        }
        for(int i = 0; i < n; i++){
            int mon=sc.nextInt();
            hs_sort[i].money=mon;
            hs[i].money=mon;
        }

        Arrays.sort(hs_sort,(h1,h2)->h2.money-h1.money);


        for(int i = 0; i < n; i++){
            int res=hs[i].money;
            int killed=0;
            for(int j=0;j<n;j++){
                if(hs[i].attack>hs_sort[j].attack){
                    res+=hs_sort[j].money;
                    killed++;
                    if(killed>=k)break;
                }
            }
            System.out.printf("%d ",res);
        }

    }

}
class hunter{
    public int attack;
    public int money;
}