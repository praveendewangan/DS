package practice.greedy;

public class _20ChoclateDistributionProblem {
    // O(nlogn),O(1)
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        if (m == 0 || n == 0)
            return 0;
      
        Collections.sort(a);
      
        if (n < m)
           return -1;
      
        int min_diff = Integer.MAX_VALUE;
      
         
        for (int i = 0; i + m - 1 < n; i++)
        {
            int diff = (int)(a.get(i+(int)m-1) - a.get(i));
            if (diff < min_diff)
                min_diff = diff;
        }
        return (long)min_diff;
    }
}
