import java.util.*;
import java.io.*;

public class _1MarksOfPCM {

    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    static class Pair {
        Integer phy;
        Integer chem;
        Integer math;
        Pair(int phy,int chem,int math) {
            this.phy = phy;
            this.chem = chem;
            this.math = math;
        }
    }
    public static void customSort(int[]phy,int[]chem,int[]math) {
        int N = phy.length;
        Pair[] pairs = new Pair[N];
        for(int i = 0; i < N; i++){
            pairs[i] = new Pair(phy[i],chem[i],math[i]);
        }
        
        Arrays.sort(pairs,(a,b) -> {
            if(a.phy == b.phy) {
                if(a.chem == b.chem) {
                    return a.math - b.math;
                } else {
                    return b.chem - a.chem;
                }
            } else {
                return a.phy - b.phy;
            }
            
        });
        
        for(int i=0; i < N; i++) {
            phy[i] = pairs[i].phy;
            chem[i] = pairs[i].chem;
            math[i] = pairs[i].math;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}