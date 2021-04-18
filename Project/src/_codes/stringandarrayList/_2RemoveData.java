package _codes.stringAndArrayList;

import java.util.List;

public class _2RemoveData {
    
    private static void removeData(List<Integer> list,int data) {
        if(list == null || list.isEmpty()){
            return;
        }
        int n = list.size() - 1;
        int i = n;
        while(i >= 0) {
            if(list.get(i) == data){
                n = list.size() - 1;
                list.set(i, list.get(n));
                list.remove(i);
            }
            i--;
        }
    }

}
