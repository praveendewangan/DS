import java.io.*;
import java.util.*;

public class _35CrosswordPuzzle {

	public static void solution(char[][] arr, String[] words, int vidx){
	    if(vidx == words.length) {
	        print(arr);
	        return;
	    }
	    String word = words[vidx];
		for(int i = 0; i < arr.length; i++){
		    for(int j = 0; j < arr[0].length; j++) {
		        if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
		          //  Horizontal try
		            if(checkIfcanPlaceHorizontally(word,arr,i,j)){
		              //  Place Horizontal
		                boolean[] v = placeHorizontally(word,arr,i,j);
		                solution(arr,words,vidx+1);
		              //  unPlace Horizontal
		                unplaceHorizontally(v,word,arr,i,j);
		            } 
		          //  vertical trye
		            if(checkIfcanPlaceVertically(word,arr,i,j)){
		              //  place vertical
		                boolean[] v = placeVertically(word,arr,i,j);
		                solution(arr,words,vidx+1);
		              //  unplace vertical
		                unplaceVertically(v,word,arr,i,j);
		            }
		        }
		    }
		}

	}
	
	private static boolean checkIfcanPlaceHorizontally(String word,char[][] arr,int r,int c) {
	   // left check 
	   if(c > 0 && arr[r][c-1] != '+') {
	       return false;
	   }
	   
	   // right check
	   if(c - 1 + word.length() >= arr[0].length) {
	       return false;
	   }
	   
	   if(c - 1 + word.length() + 1 < arr[0].length && arr[r][c - 1 + word.length() + 1] != '+') {
	       return false;
	   }
	   
	   for(int j = 0; j < word.length(); j++){
	       if(arr[r][c+j] != '-' && arr[r][c+j] != word.charAt(j)) {
	           return false;
	       }
	   }
	    return true;
	}
	private static boolean[] placeHorizontally(String word,char[][] arr,int i,int j) {
	    boolean[] v = new boolean[word.length()];
	    for(int c = 0; c < word.length(); c++){
	        if(arr[i][j + c] == '-'){
	            v[c] = true;
	            arr[i][j + c] = word.charAt(c);
	        } 
	    }
	    return v;
	}
	
	private static void unplaceHorizontally( boolean[] v,String word,char[][] arr,int i,int j) {
	    for(int c = 0; c < word.length(); c++){
	        if(v[c]){
	            arr[i][j + c] = '-';
	        } 
	    }
	}
	
	
	private static boolean checkIfcanPlaceVertically(String word,char[][] arr,int r,int c) {
	   // left check 
	   if(r > 0 && arr[r-1][c] != '+') {
	       return false;
	   }
	   
	   // right check
	   if(r - 1 + word.length() >= arr.length) {
	       return false;
	   }
	   
	   if(r - 1 + word.length() + 1 < arr.length && arr[r - 1 + word.length() + 1][c] != '+') {
	       return false;
	   }
	   
	   for(int i = 0; i < word.length(); i++){
	       if(arr[r + i][c] != '-' && arr[r + i][c] != word.charAt(i)) {
	           return false;
	       }
	   }
	    return true;
	}
	
	private static boolean[] placeVertically(String word,char[][] arr,int i,int j) {
	    boolean[] v = new boolean[word.length()];
	    for(int r = 0; r < word.length(); r++){
	        if(arr[i + r][j] == '-'){
	            v[r] = true;
	            arr[i + r][j] = word.charAt(r);
	        } 
	    }
	    return v;
	}
	
	private static void unplaceVertically( boolean[] v,String word,char[][] arr,int i,int j) {
	    for(int r = 0; r  < word.length(); r++){
	        if(v[r]){
	            arr[i + r][j] = '-';
	        } 
	    }
	}
    
	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
		solution(arr,words,0);

	}
}