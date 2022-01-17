import java.util.*;

public class _34WordPattern {

	public static boolean wordPattern(String pattern, String s) {
		String[] str = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++) {
            char ch1 = pattern.charAt(i);
            String ch2 = str[i];

            if(map.containsKey(ch1) == true) {
                if(map.get(ch1).equals(ch2) == false) return false;
            } else {
                if(set.contains(ch2) == true) {
                    return false;
                } else {
                    map.put(ch1, ch2);
                    set.add(ch2);
                }
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}
