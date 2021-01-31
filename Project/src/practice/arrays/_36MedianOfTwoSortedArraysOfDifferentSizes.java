package practice.arrays;

public class _36MedianOfTwoSortedArraysOfDifferentSizes {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int t = nums1.length + nums2.length;
        int[] a = new int[t];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                a[k] = nums1[i];
                i++;
            } else {
                a[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i < nums1.length) {
            a[k] = nums1[i];
            i++;
            k++;
        }
         while(j < nums2.length) {
            a[k] = nums2[j];
            j++;
            k++;
        }
        
        // Arrays.sort(a);
        if(t % 2 == 0){
            double n1 =  a[t/2];
            double n2 =  a[(t/2)-1];
            return (n1+n2)/2;
        } else {
            return a[t/2];
        }
    }
   
}
