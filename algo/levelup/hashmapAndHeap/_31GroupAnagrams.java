import java.util.*;
public class _31GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

        for(String str : strs) {
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            if(map.containsKey(fmap) == true) {
                map.get(fmap).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(fmap, list);
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(ArrayList<String> list : map.values()) {
            res.add(list);
        }
        return res;
	}
}
