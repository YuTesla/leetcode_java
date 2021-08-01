package leetcode;

public class KMP {
    public KMP(){};
    public static int compare(String longstr,String shortstr){
        char[] str1=longstr.toCharArray();
        char[] str2=shortstr.toCharArray();
        int[] next=getNextArr(str1);
//        for(int i:next) System.out.println(i);
        int i1=0,i2=0;
//        while(i1<str1.length&&i2<str2.length){
//            if(str1[i1]==str2[i2]){
//                i1++;
//                i2++;
//            }else{
//                if(next[i1]==0){
//                    i2=0;
//                    i1++;
//                }else{
//                    i1=i1+next[i1]+1;
//                }
//            }
//        }
        while(i1<str1.length&&i2<str2.length){
            if(str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if(next[i1]==-1){
                i2++;
            }else{
                i1=next[i1];
            }
        }
//        System.out.println(i2);
        return i2==str2.length?i2-i1:-1;
    }

    public static int[] getNextArr(char[] str){
        int[] next=new int[str.length];
        next[0]=-1;
        for(int i=1;i<str.length;i++){
            if(next[i-1]==-1)next[i]=0;
            else{
                int index=i;
                while(index>1){
                    if(str[next[index-1]]==str[i-1]){
                        next[i]=next[index-1]+1;
                        break;
                    }else{
                        index=next[index-1];
                    }
                }
                if(index==0)next[i]=0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(KMP.compare("abcabcabta","abcabt"));

    }
}
