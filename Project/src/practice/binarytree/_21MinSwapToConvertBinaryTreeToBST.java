package practice.binarytree;

import java.util.Arrays;

public class _21MinSwapToConvertBinaryTreeToBST {
    // O(nlogn),O(n)
    public int minSwap(Node node) {
        int size = 6;//tree size;
        int[] a = new int[size];
        inOrderTraversal(node,a,0);
        return minSwaps(a);
    }
    public void inOrderTraversal(Node node,int[] a,int idx) {
        if(node == null) return;
        inOrderTraversal(node.left,a,idx+1);
        a[idx] = node.data;
        inOrderTraversal(node.right,a,idx+1);
    }
    public static class Pair {
        int val;
        int idx;
        Pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int minSwaps(int arr[])
    {
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0;i<n;i++){
            pairs[i] = new Pair(arr[i],i);
        }
        Arrays.sort(pairs,(a,b) -> {
            if(a.val > b.val){
                return 1;
            } else if(a.val < b.val) {
                return -1;
            } else {
                return 0;
            }
        });
        // int cycle = 0;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(pairs[i].idx == i) {
                continue;
            } else {
                ans++;
                Pair p = pairs[i];
                pairs[i] = pairs[p.idx];
                pairs[p.idx] = p;
                i--;
            }
        }
        return ans;
    }
}
