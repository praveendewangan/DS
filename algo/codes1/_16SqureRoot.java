public class _16SqureRoot {

    public static void main(String[] args) {
        System.out.println(getRoot(10,3));
    }
    private static float getRoot(int n, int p) {
        int s = 0;
        int e = n;
        double ans = 0.0;
        while(s<=e) {
            int mid = (s+e)/2;
            if(mid * mid == n) {
                return mid;
            } else if(mid * mid < n) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        double inc = 0.1;

        for(int place=1; place <= p; place++) {
            while(ans*ans <= n) {
                ans += inc;
            }
            ans = ans - inc;
            inc = inc / 10;
        }
        return (float)ans;
    }
}
