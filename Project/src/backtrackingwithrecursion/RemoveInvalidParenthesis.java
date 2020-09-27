package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    private static void solution(String str, int mr, Set<String> sets) {
        if(mr == 0) {
            int mrn = getMin(str);
            if(mrn == 0) {
                if(!sets.contains(str)) {
                    System.out.println(str);
                    sets.add(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            solution(left + right,mr - 1,sets);
        }
    }
    private static int getMin(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                if(stack.size() == 0) {
                    stack.push(ch);
                } else if(stack.peek() == ')'){
                    stack.push(ch);
                } else if(stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int mr = getMin(str);
        solution(str,mr,new HashSet<String>());
    }
}
