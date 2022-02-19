import java.io.*;
import java.util.*;

public class _25CheckDivisibilityBy3 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    System.out.println(isDivisibleBy3(str));
  }
  private static boolean isDivisibleBy3(String num) {
        int odd = 0;
        int even = 0;
        for(int i = 0; i < num.length(); i++) {
            int bit = num.charAt(i) - '0';
            if(i % 2 == 0) {
                even += bit;
            } else {
                odd += bit;
            }
        }
        return (Math.abs(odd - even) % 11) == 0;
    }

}