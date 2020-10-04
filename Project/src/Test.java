import java.util.*;

public class Test {
    private static void solution(int[] tb,int ci,int ti){
        if(ci > ti){
            for (int i = 0; i < tb.length; i++) {
                System.out.print(tb[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < tb.length; i++) {
            if(tb[i]==0) {
                tb[i] = ci;
                solution(tb,ci+1,ti);
                tb[i] = 0;
            }
        }
    }
    private static void combination1(int cb,int tb,int ssf,int ts,String asf) {
        if(cb > tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }
        combination1(cb+1,tb,ssf+1,ts,asf+"i");
        combination1(cb+1,tb,ssf,ts,asf+"_");
    }
    private static void permutationUsingCombination(int cb,int tb,int[] ti,int ssf,int ts,String asf) {
        if(cb > tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }
        for (int i = 0; i < ti.length; i++) {
            if (ti[i] == 0) {
                ti[i] = 1;
                permutationUsingCombination(cb + 1,tb,ti,ssf + 1,ts,asf + (i + 1));
                ti[i] = 0;
            }
        }
        permutationUsingCombination(cb + 1,tb,ti,ssf,ts,asf + 0);
    }
    private static void combinationUsingPermutation(boolean[] tb,int ci,int ti,int lb) {
        if(ci > ti) {
            for (int i = 0; i < tb.length; i++) {
                if (tb[i]) {
                    System.out.print("i");
                } else{
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < tb.length; i++) {
            if (!tb[i]) {
                tb[i] = true;
                combinationUsingPermutation(tb,ci+1,ti,i);
                tb[i] = false;
            }
        }
    }
    private static void permutationOfDuplicateString(int cs,int ts,Map<Character,Integer> fmap,String asf) {
        if(cs > ts){
            System.out.println(asf);
            return;
        }
        for (Character ch : fmap.keySet()) {
            if(fmap.get(ch) > 0){
                fmap.put(ch,fmap.get(ch) - 1);
                permutationOfDuplicateString(cs + 1,ts,fmap,asf + ch);
                fmap.put(ch,fmap.get(ch) + 1);
            }
        }
    }
    private static void permuteString(String str,int k,String asf) {
        if(k == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            permuteString(str,k-1,asf + ch);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
//        int boxex = scn.nextInt();
//        int items = scn.nextInt();
//        permutation1(new int[boxex],1,items);
//        combination1(1,boxex,0,items,"");
//        permutationUsingCombination(1,boxex,new int[items],0,items,"");
//        combinationUsingPermutation(new boolean[boxex],1,items,-1);
//        Map<Character,Integer> fmap = new HashMap<>();
//        for (Character ch : str.toCharArray()) {
//            if(fmap.containsKey(ch)) {
//                fmap.put(ch,fmap.get(ch) + 1);
//            } else {
//                fmap.put(ch,1);
//            }
//        }
//        permutationOfDuplicateString(1,str.length(),fmap,"");
        String ustr = "";
        Set<Character> sets = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if(!sets.contains(ch)){
                ustr += ch;
            }
        }
        permuteString(ustr,k,"");
    }
}
