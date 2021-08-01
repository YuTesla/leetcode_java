package offer;

import java.util.ArrayList;
import java.util.List;

public class fortest {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.remove(l.size()-1);
        for(int i:l){
            System.out.println(i);
        }
    }


}
