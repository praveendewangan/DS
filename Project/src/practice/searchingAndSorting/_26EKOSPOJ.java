package practice.searchingAndSorting;

public class _26EKOSPOJ {
    
    public static void main(String[] args) {
        int n = 4;
        int m = 7;
        int[] a = new int[]{20,15,10,17};
        int maxheight = 0;
        for(int val : a){
            if(maxheight < val) {
                maxheight = val;
            }
        }
        int i = 0;
        int j = maxheight;
        // System.out.println(j);
        int ans = 0;
        while(i < j) {
            int mid = (i+j) / 2;
            if(isValid(a,mid,m)){
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean isValid(int[] a,int mid,int m) {
        int sum = 0;
        for(int val : a){
            if(val > mid) {
                sum += (val-mid);
            }
        }
        if(sum >= m){
            return true;
        }
        return false;
    }
}
