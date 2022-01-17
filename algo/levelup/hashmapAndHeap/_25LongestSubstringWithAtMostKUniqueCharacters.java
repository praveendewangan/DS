import java.util.*;

public class _25LongestSubstringWithAtMostKUniqueCharacters {

	public static int solution(String str, int k) {
        int len = 0;
        int acq = -1;
        int rel = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while(acq < str.length() - 1) {
                flag1 = true;
                acq++;
                char ch = str.charAt(acq);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.size() <= k) {
                    len = Math.max(len, acq - rel);
                } else {
                    break;
                }
            }
            while(rel < acq) {
                flag2 = true;
                rel++;
                char ch = str.charAt(rel);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);
                if(map.size() == k) break;
            }
            if(flag1 == false && flag2 == false) break;
        }
        return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
