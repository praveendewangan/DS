import java.io.*;
import java.util.*;

public class _2PrintValueOfRSBmask {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int mask = (n & (-n));
    System.out.println(Integer.toBinaryString(mask));
  }

}