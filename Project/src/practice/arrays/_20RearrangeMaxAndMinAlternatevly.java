package practice.arrays;

public class _20RearrangeMaxAndMinAlternatevly {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        // ans  {5,1,4,2,3};
        int i = 0;
        int mini = 0;
        int maxi = a.length-1;
        // Max Element
        int n = a.length + 1;
        while(i < a.length){
            int val = 0;
            if(i % 2 == 0){
                val = a[i] + (a[maxi] % n) * n;
                a[i] = val;
                maxi--;
            } else {
                val = a[i] + (a[mini] % n) * n;
                a[i] = val;
                mini++;
            }
            i++;
        }
       
        
        for(int val : a) {
            System.out.print(val / n + " "); 
        }
    }
}
