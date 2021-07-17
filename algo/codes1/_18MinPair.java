import java.util.Arrays;

public class _18MinPair {
    public static void main(String[] args) {
        int[] a1 = {-1,5,10,20,3};
        int[] a2 = {26,134,135,15,17};
        Arrays.sort(a1);
        Arrays.sort(a2);
        int p1 = 0;
        int p2 = 0;
        int dif = Integer.MAX_VALUE;
        for(int x : a1) {
            int lb = lowerBound(a2,x);

            if(lb >= 1 && x - a2[lb-1] < dif) {
                dif = x-a2[lb-1];
                p2 = x;
                p1 = a2[lb-1];
            }

            if(lb != a2.length && a2[lb]-x < dif) {
                dif = a2[lb]-x;
                p1 = x;
                p2 = a2[lb];
            }
        }
        System.out.println(p1 + " - " + p2);
    }

    private static int lowerBound(int[] a, int x) {
        int s = 0;
        int e = a.length-1;
        int ans = -1;

        while(s<=e) {
            int mid = (s+e)/2;
            if(a[mid] == x) {
                return mid;
            } else if(a[mid] > x) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
