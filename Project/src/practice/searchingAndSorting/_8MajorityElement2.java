package practice.searchingAndSorting;

public class _MajorityElement2 {
    // O(n),O(1)
    static int majorityElement(int a[], int size)
    {
        int candidate = findCandidate(a);
        int count = 0;
        for(int val : a){
            if(val == candidate){
                count++;
            }
        }
        if(count > size/2){
            return candidate;
        }
        return -1;
    }
    
    static int findCandidate(int[] a) {
        int candidate = a[0];
        int count = 1;
        for(int i=1;i<a.length;i++){
            if(a[i] == candidate){
                count++;
            } else {
                count--;
                if(count == 0){
                    candidate = a[i];
                    count++;
                }
            }
        }
        return candidate;
    }
}
