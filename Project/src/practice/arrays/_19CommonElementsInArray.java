package practice.arrays;

import java.util.ArrayList;

public class _19CommonElementsInArray {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i != A.length && j != B.length && k != C.length){
            if(A[i] < B[j] || A[i] < C[k]) {
                i++;
            } else if(B[j] < A[i] || B[j] < C[k]){
                j++;
            } else if(C[k] < A[i] || C[k] < B[j]){
                k++;
            } else if(A[i] == B[j] && A[i] == C[k]){
                if(!list.contains(A[i]))
                    list.add(A[i]);
                i++;
                j++;
                k++;
            }
        }
        return list;
    }
}
