package practice.searchingAndSorting;

public class _32DoubleHelix {
    // O(n),O(1)
    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62};
        int[] b = new int[]{1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100};
        
        int ans = 0;
        int s1 = 0, s2 = 0, i = 0, j = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]){
                s1 += a[i++];
            } else if(a[i]> b[j]) {
                s2 += b[j++];
            } else {
                ans += Math.max(s1, s2) + a[i];
                s1 = 0;
                s2 = 0;
                i++;
                j++;
            }
        }
        while(i < a.length) {
            s1 += a[i++];
        }
        while(j < b.length) {
            s2 += b[j++];
        }
        ans += Math.max(s1, s2);
        System.out.println(ans);
    } 
}
