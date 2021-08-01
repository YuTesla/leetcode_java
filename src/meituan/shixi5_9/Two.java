package meituan.shixi5_9;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int[] hs = new int[n];
        for (int i = 0; i < n; i++) {
            hs[i] = sc.nextInt();
        }

        int cnt=0;
        int maxcnt=0;
        int pos=1;
        for(int i=0;i<n;i++){
            if(maxcnt>=m){
                pos=i+1-m;
                break;
            }
            if(hs[i]<=h){
                cnt++;
                maxcnt=Math.max(maxcnt,cnt);
            }else{
                cnt=0;
            }
        }
        System.out.println(maxcnt>=m?pos:-1);


//        int[] ifk=new int[n];
//        for(int i=0;i<n;i++){
//            ifk[i]=Integer.MAX_VALUE;
//        }
//        for(int i=0;i<n;i++){
//            if(i+m>=n)break;
//            if(hs[i]<=h){
//                boolean lx=true;
//                for(int j=i;j<i+m;j++){
//                    if(hs[j]<=h){
//                        //可优化
//                        lx=true;
//                    }else{
////                        i=j+1;
//                        lx=false;
//                        break;
//                    }
//                }
//                if(lx){
//                    ifk[i]=hs[i];
//                }
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            System.out.println(ifk[i]);
//        }
//
//        int res=-1;
//        int minm=Integer.MAX_VALUE;
//        for(int i=0;i<n;i++){
//            if(minm>ifk[i]){
//                minm=ifk[i];
//                res=i;
//            }
//        }
//        System.out.println(res);
    }
}
