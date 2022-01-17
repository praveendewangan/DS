import java.util.*;
public class _42XofaKindinaDeckofCardsLC914 {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < deck.length; i++) {
            int val = deck[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int ans = 0;
        for(int key : map.keySet()) {
            int freq = map.get(key);
            ans = gcd(ans, freq);
        }
        return ans >= 2;
    }
}