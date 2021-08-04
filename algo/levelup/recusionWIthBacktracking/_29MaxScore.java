import java.io.*;
import java.util.*;

public class _29MaxScore {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
	    if(idx == words.length) {
	        return 0;
	    }
// 		No call
        int noAns = solution(words,farr,score,idx+1);
        
        // exhaust frequency
        boolean flag = true;
        int myScore = 0;
        String word = words[idx];
        for(int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i) - 'a';
            myScore += score[charIdx];
            if(farr[charIdx] <= 0) {
                flag = false;
            }
            farr[charIdx]--;
        }
        // Yes call
        int yesAns = 0;
        if(flag) {
            yesAns = myScore + solution(words,farr,score,idx+1); 
        }
        
        // Reset frequency
        for(int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i) - 'a';
            farr[charIdx]++;
        }
		return Math.max(noAns,yesAns);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}