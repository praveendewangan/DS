package bitmanupulation;

import java.util.*;

public class _6MinimumNoOfDevelopers {
    private static List<Integer> sol = new ArrayList<>();
    private static void solution(int[] people,int nskills,int cp,List<Integer> onesol,int smask) {
        if(cp == people.length){
            if(smask == (1 << nskills) - 1){
                if (sol.size() == 0 || onesol.size() < sol.size()) {
                    sol = new ArrayList<>();
                }
            }
            return;
        }
        solution(people,nskills,cp + 1,onesol,smask);
        onesol.add(cp);
        solution(people,nskills,cp + 1,onesol,(smask | people[cp]));
        onesol.remove(onesol.size() - 1);
    }
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        int n = scn.nextInt();
        Map<String,Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(scn.next(),i);
        }
        int np = scn.nextInt();
        int[] people = new int[np];
        for (int i = 0; i < np; i++) {
            int personSkills = scn.nextInt();
            for (int j = 0; j < personSkills; j++) {
                String skill = scn.next();
                int snum = mp.get(skill);
                people[i] = people[i] | (1 << snum);
            }
        }
        solution(people,n,0,new ArrayList<>(),0);
        System.out.println(sol);
    }
}
