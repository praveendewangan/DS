public class _12SparseSearch {
    
    public int sparseSearch(String[] a,String key) {
        int s = 0;
        int e = a.length-1;

        while(s <= e) {
            int mid = (s+e)/2;
            int midLeft = mid - 1;
            int midRight = mid + 1;

            if(a[mid].isEmpty()) {
                while(true) {
                    if(midLeft < s && midRight > e) {
                        return -1;
                    } else if(midRight <= e && !a[midRight].isEmpty()) {
                        mid = midRight;
                        break;
                    } else if(midLeft >= s && !a[midLeft].isEmpty()) {
                        mid = midLeft;
                        break;
                    }
                    midLeft--;
                    midRight++;
                }
            } else if(a[mid].equals(key)) {
                return mid;
            } else if(a[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
    }
}
