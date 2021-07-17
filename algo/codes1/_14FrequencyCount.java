public class _14FrequencyCount {
    
    public static void main(String[] args) {
        int[] a = {0,1,1,1,2,2,2,3,4,4,5,10};
        int key = 2;
        System.out.println(upperBound(a, key) - lowerBound(a, key) + 1);
    }
    private static int lowerBound(int[] a,int key) {
        int s = 0;
        int e = a.length-1;
        int ans = -1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == key) {
                ans = mid;
                e = mid - 1;
            } else if(a[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] a,int key) {
        int s = 0;
        int e = a.length-1;
        int ans = -1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == key) {
                ans = mid;
                s = mid + 1;
            } else if(a[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
