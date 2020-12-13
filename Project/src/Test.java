import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2};
        int n = 11;
        int maxR = a[0];
        int step = a[0];
        int jump = 1;
        if(n == 1) {
//            return 0;
        } else if(a[0] == 0) {
//            return -1;
        } else {
            for (int i = 1; i < n; i++) {
                if(i == n-1) {
//                    return jump;
                }
                maxR = Math.max(maxR,a[i] + i);
                step--;
                if(step == 0) {
                    jump++;
                    if(i >= maxR) {
//                        return -1;
                    }
                        step = maxR - i;

                }
            }
        }
//        return -1;
    }
}
