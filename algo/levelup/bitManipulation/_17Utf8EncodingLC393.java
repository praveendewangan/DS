import java.io.*;
import java.util.*;

public class _17Utf8EncodingLC393 {

    public static boolean solution(int[] arr) {
        int remByte = 0;
        for(int val : arr) {
            if(remByte == 0) {
                if((val >> 7) == 0b0) {
                    // 1 byte character
                    remByte = 0;
                } else if((val >> 5) == 0b110) {
                    // 2 byte character
                    remByte = 1;
                } else if((val >> 4) == 0b1110) {
                    // 3 byte character
                    remByte = 2;
                } else if((val >> 3) == 0b11110) {
                    // 4 byte character
                    remByte = 3;
                } else {
                    return false;
                }
            } else {
                // check for remain byte i.e. it begin with 10_____
                if((val >> 6) != 0b10) {
                    return false;
                }
                remByte--;
            }
        }
        // return true;
        return remByte == 0;
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}