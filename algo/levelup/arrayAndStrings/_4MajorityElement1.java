import java.util.*;

public class _4MajorityElement1 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] arr) {
        int val = arr[0];
        int count = 1;
        int i = 1;
        
        while(i < arr.length) {
            if(arr[i] == val) {
                count++;
            } else {
                if(count > 0) {
                    count--;
                } else {
                    val = arr[i];
                    count = 1;
                }
            }
            i++;
        }
        count = 0;
        for(i = 0; i < arr.length; i++){
            if(val == arr[i]) {
                count++;
            }
        }
        if(count > (arr.length/2)) {
            System.out.println(val);
        } else {
            System.out.println("No Majority Element exist");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}