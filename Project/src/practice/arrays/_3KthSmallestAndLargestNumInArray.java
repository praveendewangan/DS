package practice.arrays;

public class _3KthSmallestAndLargestNumInArray {
    public static void main(String[] args) {
//        int[] a1 = {7,10,4,3,20,15};
//        int k1 = 3; // 3rd Smallest
//        int[] a2 = {7,10,4,20,15};
//        int k2 = 4; // 4th Largest
//
//        for (int i = 0; i < a1.length; i++) {
//            for (int j = i + 1; j < a1.length; j++) {
//                if(a1[i] < a1[j]) {
//                    int temp = a1[j];
//                    a1[j] = a1[i];
//                    a1[i] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < a1.length; i++) {
//            System.out.print(a1[i]+",");
//        }
//        System.out.println();
//        for (int i = 0; i < a2.length; i++) {
//            for (int j = i + 1; j < a2.length; j++) {
//                if(a2[i] > a2[j]) {
//                    int temp = a2[j];
//                    a2[j] = a2[i];
//                    a2[i] = temp;
//                }
//            }
//        }
//        System.out.println(a1[k1-1]);
//
//        for (int i = 0; i < a2.length; i++) {
//            System.out.print(a2[i]+",");
//        }
//
//        System.out.println();
//        System.out.println(a2[k2-1]);


        int[] a = {7,10,4,3,20,15};
        int k = 3; // 3rd Smallest and Largest
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length ; j++) {
                if(a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println();
        System.out.println("K-Largest " + a[a.length - k]);
        System.out.println("K-Smallest " + a[k - 1]);
    }
}
