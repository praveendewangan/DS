public class _17MaximizeDistanceToClosestPersonLC849 
    
    //     approch 1
        public int maxDistToClosest(int[] seats) {
            int dist = 0;
            int zeros = 0;
            int idx = 0;
            while(seats[idx] != 1) {
                zeros++;
                idx++;
            }
            idx++;
            dist = zeros;
            zeros = 0;
            
            while(idx < seats.length) {
                while(idx < seats.length && seats[idx] != 1) {
                    idx++;
                    zeros++;
                }
                if(idx == seats.length) {
                    break;
                }
                idx++;
                dist = Math.max(dist,(zeros+1)/2);
                zeros = 0;
            }
            return Math.max(zeros,dist);
        }
    //     approch 2
        public int maxDistToClosest1(int[] seats) {
            int n = seats.length;
            int[] left = new int[n];
            if(seats[0] != 1)
                left[0] = n;
            for(int i = 1; i < n; i++){
                if(seats[i] == 1) {
                    left[i] = 0;
                } else if(left[i-1] == n ) {
                    left[i] = n;
                } else {
                    left[i] = left[i-1] + 1;
                }
            }
            int[] right = new int[n];
            if(seats[n-1] != 1)
                right[n-1] = n;
            for(int i = n-2; i >= 0; i--){
                if(seats[i] == 1) {
                    right[i] = 0;
                } else if(right[i+1] == n ) {
                    right[i] = n;
                } else {
                    right[i] = right[i+1] + 1;
                }
            }
            int max = 0;
            for(int i = 0; i < n; i++){
                int min = Math.min(left[i],right[i]);
                max = Math.max(min,max);
            }
            return max;
        }
    }