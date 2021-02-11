package practice.string;

import java.util.Arrays;

import org.w3c.dom.Text;

public class _24BoyerMoorePatternSearch {
    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray(); 
         char pat[] = "ABC".toCharArray(); 
         search(txt, pat); 
    }
    private static void search(char[] txt,char[] pat) {
        int n = txt.length;
        int m = pat.length;

        // Creating badMatch char array
        int[] badMatch = new int[256];
        /* Fill the bad character array by calling  
         the preprocessing function badCharHeuristic()  
         for given pattern */
        badCharHeuristic(pat, m, badMatch); 
        
        int i = 0;
        while(i <= (n-m)) {
            int j = m-1;
            while(j>=0 && pat[j] == txt[i+j]){
                j--;
            } 
            if(j < 0) {
                System.out.println(i);
                i += (i+m < n) ? m-badMatch[txt[i+m]] : 1;
            }
            else {
                i += Math.max(1, j-badMatch[txt[i+j]]);
            }
        }
    }
    private static void badCharHeuristic(char[] pat,int m,int[] badMatch) {
        Arrays.fill(badMatch, m);
        for (int i = 0; i < pat.length; i++) {
            badMatch[(int)pat[i]] = m-i-1;
        }
    }
}
