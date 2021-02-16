package practice.searchingAndSorting;

public class _4CountSquare {
    // O(sqrt(N)),O(1)
    static int countSquares(int N) {
        if(N == 0 || N == 1) return N;
        int count = 0;
        for(int i =1;i*i < N;i++) {
            count++;
        }
        return count;
    }
}
