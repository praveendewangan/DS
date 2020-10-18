package dynamicprograms;

import java.util.Scanner;

public class _13ArrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int b = 1;
        int s = 1;

        for (int i = 2; i <= n; i++) {
            int nb = s;
            int ns = b + s;

            b = nb;
            s = ns;
        }
        int total = b + s;
        System.out.println(total*total);
    }
}
