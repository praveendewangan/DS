public class _15SearchInRoatedArray {
    public static void main(String[] args) {
        int[] a = {7,9,10,1,2,3,4,5,6};
        int key = 4;
        System.out.println(search(a, key));
    }
    private static int search(int[] a,int key) {
        int s = 0;
        int e = a.length-1;
        int ans = -1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == key) {
                return mid;
            } 

            if(a[s] <= a[mid]) {
                if(key >= a[s] && key <= a[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if(key >= a[mid] && key <= a[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return ans;
    }
}
