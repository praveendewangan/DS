package array;

import java.util.Scanner;

public class _1Frequency {
    public static void main(String[] args) {
        System.out.println("Enter input number :: ");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int num = scn.nextInt();
        int reminder = 0;
        int counter = 0;
        while (num != 0) {
            reminder = num % 10;
            num = num/10;
            if(reminder == n){
                counter++;
            }
        }
        if(counter > 0){
            System.out.println(" Frequency of "+n+" in given number is "+counter);
        } else {
            System.out.println(" Frequency of "+n+" in given number is 0");
        }
    }
}
