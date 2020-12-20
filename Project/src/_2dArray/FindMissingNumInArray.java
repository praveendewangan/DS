package _2dArray;

public class FindMissingNumInArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,5,6};
        System.out.println(getMissNum(a));
    }
    private static int getMissNum(int[] a) {
        int num = -1;
        int i = 0;
        int l = a.length;
        int m = (i+l)/2;
        int fm = m;
        while (true) {
            if(m >= a.length) {
                l = fm;
                m = (i+l)/2;
            } else if(a[m] != m+1){
                num = m+1;
                break;
            } else {
              m = m+1;
            }
        }
        return num;
    }
}
