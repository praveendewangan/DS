public enum _17AngerBirdsOrCows {
    public static void main(String[] args) {
        int[] nests = {1,2,4,8,9};
        int birds = 3;
        System.out.println(getMaxDiff(nests,birds));
    }

    private static int getMaxDiff(int[] nests,int birds) {
        int n = nests.length;
        int s = 0;
        int e = nests[n-1] - nests[0];
        int ans = -1;

        while(s<=e) {
            int mid = (s+e)/2;
            if(birdPosibleToStay(nests,birds,mid)){
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    private static boolean birdPosibleToStay(int[] nests,int birds,int sep) {
        int b = 1;
        int location = nests[0];

        for(int i = 1; i < nests.length; i++) {
            int cur_location = nests[i];
            if(cur_location - location >= sep) {
                b++;
                location = cur_location;
                if(b == birds) {
                    return true;
                }
            }
        }
        return false;
    }
}
