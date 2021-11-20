import java.util.Map;

public class _27TripletInGP {
    
    
    private static int countTriplet(int[] arr,int r) {
        int n = arr.length;
        Map<Integer,Integer> right = null, left = null;

        for(int val : arr) {
            right.put(val,right.getOrDefault(val, 0)+1);
            left.put(val,0);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            int val = arr[i];
            right.put(val, right.get(val)-1);

            if(val % r == 0) {
                int b = val;
                int a = val / r;
                int c = val * r;
                ans += left.get(a) * right.get(c);
            }
            left.put(val, left.getOrDefault(val, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,16,4,16,64,16};
        int r = 4;
        System.out.println(countTriplet(a, r));
    }
}
