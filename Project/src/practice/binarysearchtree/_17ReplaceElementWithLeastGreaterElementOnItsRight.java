package practice.binarysearchtree;

public class _17ReplaceElementWithLeastGreaterElementOnItsRight {
    // O(n),O(1)
    public void replace(int[] a) {
        int rightMax = -1;
        for(int i=a.length-1;i>=0;i--) {
            int newMax = Math.max(rightMax,a[i]);
            a[i] = rightMax;
            rightMax = newMax;
        }
    }
}
