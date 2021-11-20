import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class _43MeetingRoomsOneOfficial{
    public static boolean meetingRooms(int intervals[][]){
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        int ep = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < ep) {
                return false;
            } else
                ep = intervals[i][1];
        }
        return true;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}