package practice.searchingAndSorting;

public class _5MiddleOfThree {
    // O(1),O(1)
    int middle(int A, int B, int C){
        if((A > B && B > C) || (C > B && B > A)) {
            return B;
        } else if((B > A && A > C) || (C > A && A > B)) {
            return A;
        } else {
            return C;
        }
    }
}
