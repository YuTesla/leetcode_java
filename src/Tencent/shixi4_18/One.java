package Tencent.shixi4_18;
import java.util.Scanner;
import java.util.*;
public class One {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String ts=sc.nextLine();
            int t=Integer.parseInt(ts);
            for(int i = 0; i < t; i++){
                String a=sc.nextLine();
                String b=sc.nextLine();
                if(isEqual(a,b)){
                    System.out.print("Yes");
                }else{
                    System.out.print("NO");
                }
                if(i<t-1) System.out.println();
            }

        }
        public static boolean isEqual(String a,String b){
            if(a.length()%2==1){
                char[] as=a.toCharArray();
                char[] bs=b.toCharArray();
                for(int i=0;i<as.length;i++){
                    if(as[i]!=bs[i]){
                        return false;
                    }
                }
                return true;
            }else{
                int mid=a.length()/2;
                return (isEqual(a.substring(0,mid),b.substring(mid,a.length()))&&isEqual(b.substring(0,mid),a.substring(mid,a.length())))
                        ||(isEqual(a.substring(0,mid),b.substring(0,mid))&&isEqual(b.substring(mid,a.length()),a.substring(mid,a.length())));
            }
        }

}
