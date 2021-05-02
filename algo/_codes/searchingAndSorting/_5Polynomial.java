public class _5Polynomial {
    if(x == 0) 
            return 0;
        
        int xval = x;
        int sum = 0;

        for(int n = N; n >= 1; n--) {
            sum += n * xval;
            xval *= x;
        }
        return sum;
}
