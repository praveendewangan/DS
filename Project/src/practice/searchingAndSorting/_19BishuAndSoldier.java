package practice.searchingAndSorting;

public class _19BishuAndSoldier {
    // O(n*m),O(1)
    public static void main(String[] args) {
        int n = 7;
        int[] a = new int[]{1,2,3,4,5,6,7};
        int m =  3;
        int[] b = new int[]{3,10,2};
        
        for(int i=0;i<m;i++) {
            int count = 0;
            int sum = 0;
            for(int j=0;j<n;j++){
                if(a[j] <= b[i]){
                    count++;
                    sum += a[j];
                }
            }
            if(count != 0){
                System.out.println(count + " " + sum);
            }
        }    
    }
}
