import java.util.*;

public class _36PartitionLabelsLC763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return list;
        }
        int n = s.length();
        int max = 0;
        int prev = -1;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(s.charAt(i),i);
        }
        
        for(int i = 0; i < n; i++) {
            max = Math.max(max,mp.get(s.charAt(i)));
            if(i == max) {
                list.add(max-prev);
                prev = max;
            }
        }
        return list;
    }
}
