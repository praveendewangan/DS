package practice.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9KthElementInMatrix {
	// Eficient Approch O(n^2),O(k);

    public static class Heap {
        private List<Integer> data;
        Heap(){
            this.data = new ArrayList<>();
        }
        
        void add(int n){
            data.add(n);
            if(data.size() > 1){
                upheapify(size()-1);
            }
        }
        int size(){
            return data.size();
        }
        void upheapify(int i) {
            if(i == 0) return;
            int pi = (i-1)/2;
            if(data.get(i) > data.get(pi)){
                swap(i,pi);
                upheapify(pi);
            }
        }
        void swap(int i,int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }
        int remove(){
            if(size() == 0) return -1;
            swap(0,size()-1);
            int val = data.remove(size()-1);
            downheapify(0);
            return val;
        }
        void downheapify(int pi) {
            int min = pi;
            int li = 2 * pi + 1;
            if(li < size() && data.get(li) > data.get(min)){
                min = li;
            }
            int ri = 2 * pi + 2;
            if(ri < size() && data.get(ri) > data.get(min)){
                min = ri;
            }
            if(min != pi) {
                swap(pi,min);
                downheapify(min);
            }
        }
        int peek(){
            if(size() == 0) return -1;
            return data.get(0);
        }
        int getLast(){
            return data.get(size()-1);
        }
        
        int removeLast(){
            return data.remove(size()-1);
        }
    }
	public static int kthSmallest(int[][]mat,int n,int k)
	{
	    int[] a = new int[n*n];
	    Heap q = new Heap();
	    int x = 0;
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++){
	            if(q.size() < k){
	                q.add(mat[i][j]);
	            } else {
	                if(q.peek() > mat[i][j]){
	                    q.remove();
    	                q.add(mat[i][j]);
	                }
	            }
	        }
	    }
	    return q.remove();
    }
    
    // Broout Fource O(n^2logn),O(n2)
    public static int kthSmallest1(int[][]mat,int n,int k)
	{
	    int[] a = new int[n*n];
	    int x = 0;
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++){
	            a[x] = mat[i][j];
	            x++;
	        }
	    }
	    Arrays.sort(a);
	    return a[k-1];
    }
}
