package leetcode;

public class Manacher {
    public Manacher(){};
    public static String getStr(String palstr){
        if(palstr.length()<1)return "";
        char[] str=getManacherStr(palstr);
//        for(char c:str) System.out.println(c);
        int len=str.length;
        int R=-1;
        int mid=-1;
        int[] pallen=new int[len];
//        int c=1;
//        while(c<len){
//            if(c>R){
//                int l=c-1,r=c+1;
//                while(l>=0&&r<len){
//                    if(str[l]!=str[r]){
//                        break;
//                    }
//                    l--;
//                    r++;
//                }
//                R=r-1;
//                mid=c;
//                pallen[c]=r-c-1;
//            }else{
//                int mirrc=c-2*(c-mid);
//                int mirrl=mirrc-pallen[mirrc];
//                if(mirrl>mid-pallen[mid]){
//                    pallen[c]=pallen[mirrc];
//                }else if(mirrl<mid-pallen[mid]){
//                    pallen[c]=mirrc-(mid-pallen[mid]);
//                }else{
//                    int l=c-pallen[mirrc]-1;
//                    int r=c+pallen[mirrc]+1;
//                    while(l>=0&&r<len){
//                        if(str[l]!=str[r]){
//                            break;
//                        }
//                        l--;
//                        r++;
//                    }
//                    if(r>R+1){
//                        R=r-1;
//                        mid=c;;
//                    }
//                    pallen[c]=r-c-1;
//                }
//            }
//            c++;
//        }
        for(int c=0;c<str.length;c++){
            //前半段表示第二种情况，直接计算两种O(1)情况，第二种情况需要扩，但min中两者相等，任取其一在后面的while继续扩展
            pallen[c]=c<R?Math.min(pallen[c-2*(c-mid)],R-c):1;
            while(c+pallen[c]<str.length&&c-pallen[c]>-1){
                if(str[c+pallen[c]]==str[c-pallen[c]]){
                    pallen[c]++;
                }else{
                    break;
                }
            }
        }

        int index=0,max=-1;
        for(int i=0;i<pallen.length;i++){
            if(pallen[i]>max){
                max=pallen[i];
                index=i;
            }
        }
        return palstr.substring((index-pallen[index])/2,(index+pallen[index])/2);

    }

    public static char[] getManacherStr(String palstr){
        char flag='#';
        char[] ManacherStr=new char[palstr.length()*2+1];
        ManacherStr[0]=flag;
        for(int i=0;i<palstr.length();i++){
            ManacherStr[i*2+1]=palstr.charAt(i);
            ManacherStr[i*2+2]=flag;
        }
        return ManacherStr;
    }

    public static void main(String[] args) {
        System.out.println(Manacher.getStr("bacabab"));
    }
}
