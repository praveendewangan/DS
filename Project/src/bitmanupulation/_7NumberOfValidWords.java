package bitmanupulation;

import java.util.*;

public class _7NumberOfValidWords {
    private static List<Integer> findNumofValidWords(String[] words,String[] puzzles) {
        Map<Character,ArrayList<Integer>> mp  = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            mp.put((char) ( 'a' + i),new ArrayList<>());
        }
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                int bit = ch - 'a';
                mask = mask | (1 << bit);
            }
            Set<Character> uset = new HashSet<>();
            for (char ch : word.toCharArray()) {
                if(uset.contains(ch)) {
                    continue;
                }
                uset.add(ch);
                mp.get(ch).add(mask);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int pmask = 0;
            for (char ch : puzzle.toCharArray()) {
                int bit = ch - 'a';
                pmask = pmask | (1 << bit);
            }
            char ch = puzzle.charAt(0);
            List<Integer> wordToCheck = mp.get(ch);
            int count = 0;
            for (int wmask : wordToCheck) {
                if ((wmask & pmask) == wmask) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        List<Integer> ans = findNumofValidWords(words,puzzles);
        for (int i = 0; i < puzzles.length; i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
