import java.util.*;

public class _37BoatsToSavePeople {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
        int count = 0;
        int n = people.length;
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int sum = people[left] + people[right];
            if(sum <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            count++;
        }
        return count;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] people = new int[n];

    for (int i = 0; i < n; i++)
      people[i] = scn.nextInt();

    int limit = scn.nextInt();
    int boats = numRescueBoats(people, limit);
    System.out.println(boats);
  }
}