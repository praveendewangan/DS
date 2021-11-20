public class _48FirstNegativeInEveryWindowOfSizeK {
    // https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] res = new long[N - (K-1)];
        int idx = N;
        for(int i= N-1; i >= N-K; i--) {
            if(A[i] < 0) {
                idx = i;
            }
        }
        for(int i = N-K; i>= 0; i--) {
            if(A[i] < 0) {
                idx = i;
            }
            if(idx < i+K) {
                res[i] = A[idx];
            }
        }
        return res;
    }
}