package practice.arrays;

import java.util.Arrays;


/*Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
        Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

        Input:
        K = 2, N = 4
        Arr[] = {1, 5, 8, 10}
        Output: 5*/
public class _9MinimizeMaxDiffBetweenHeight {
    public static void main(String[] args) {
        int[] a = {6, 1, 9, 1, 1, 7, 9, 5, 2, 10};
        int k = 4 ;// o/p 5
        int n = 10;
        getMinDiff(a,n,k);
    }
    // Best approtch
    static int getMinDiff(int[] a, int n, int k) {
        int max = 0, min = 0,r = a[n-1] - a[0];
        Arrays.sort(a);
        for(int i = 1; i < n; i++) {
            if(a[i] >= k) {
                max = Math.max(a[i-1] + k, a[n-1] - k);
                min = Math.min(a[i] - k, a[0] + k);
                r = Math.min(r, max - min);
            }
        }
        return r;
    }
    static int getMinDiff2(int[] a, int n, int k) {
        if(n == 1) {
            return 0;
        }
        Arrays.sort(a);
        int ans = a[n-1] - a[0];
        int small = a[0] + k;
        int big = a[n-1] - k;
        if(small > big) {
            int temp = big;
            big = small;
            small = temp;
        }

        for(int i = 1; i < n-1; i++) {
            int sub = a[i] - k;
            int add = a[i] + k;
            if(small <= sub || big >= add)
                continue;

            if(big - sub <= add - small) {
                small = sub;
            } else {
                big = add;
            }
        }
        return Math.min(ans,big - small);
    }
}



/*

class Solution{
    public:
    int getMinDiff(int arr[], int n, int k) {
        vector<pair<int, int>> v;
        vector<int> taken(n);

        // we will store all possible heights in a vector
        for(int i = 0; i < n; i++){
            if(arr[i] - k >= 0){
                v.push_back({arr[i] - k, i});
            }
            v.push_back({arr[i] + k, i});
        }
        sort(v.begin(), v.end());
        int elements_in_range = 0;
        int left = 0;
        int right = 0;

        // By two pointer we will traverse v and whenever we will get a range
        // in which all towers are included, we will update the answer.
        while(elements_in_range < n && right < v.size()){
            if(taken[v[right].second] == 0){
                elements_in_range++;
            }
            taken[v[right].second]++;
            right++;
        }
        int ans = v[right - 1].first - v[left].first;
        while(right < v.size()){
            if(taken[v[left].second] == 1){
                elements_in_range--;
            }
            taken[v[left].second]--;
            left++;

            while(elements_in_range < n && right < v.size()){
                if(taken[v[right].second]==0){
                    elements_in_range++;
                }
                taken[v[right].second]++;
                right++;
            }

            if(elements_in_range == n){
                ans = min(ans, v[right - 1].first - v[left].first);
            }
            else{
                break;
            }
        }
        return ans;
    }
};
*/
