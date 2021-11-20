/import java.util.*;

public class _6MajorityElement2 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        int v1 = -1;
        int v2 = -1;
        int c1 = 0;
        int c2 = 0;
        for(int i = 1; i < arr.length; i++){
            if(v1 == arr[i]) {
                c1++;
            } else if(v2 == arr[i]) {
                c2++;
            } else {
                if(c1 == 0) {
                    v1 = arr[i];
                    c1 = 1;
                } else if(c2 == 0) {
                    v2 = arr[i];
                    c2 = 1;
                } else {
                    c1--;
                    c2--;
                }
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == v1) {
                c1++;
            } else if(arr[i] == v2) {
                c2++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(c1 > (arr.length/3)) {
            list.add(v1);
        }
        if(c2 > (arr.length/3)) {
            list.add(v2);
            
        }
        return list;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}