package practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _16WordBreak {
    // APproch 1, O(nLogn)
    static Map<String,Integer> hm = new HashMap<>();
    public static int wordBreak(String A, ArrayList<String> B )
    {
       return find(A,B,"");
    }
    
    private static int find(String A,ArrayList<String> B,String asf){
        if(A.length() == 0){
            if(asf.length() > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        
        for(int i=0;i<A.length();i++){
            String left = A.substring(0,i+1);
            int f = 0;
            if(B.contains(left)) {
                String right = A.substring(i+1);
                hm.put(left,1);
                if(B.contains(right)) {
                    return 1;
                }
                if(hm.get(right) != null && hm.get(right) == 1){
                    return 1;
                } else if(find(right,B,asf+left+" ") == 1) {
                    hm.put(right,1);
                    return 1;
                } else if(find(right,B,asf+left+" ") == 0){
                    hm.put(right,0);
                    return 0;
                }
            }
        }
        return 0;
    }
}
