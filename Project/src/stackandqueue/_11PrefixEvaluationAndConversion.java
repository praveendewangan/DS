package stackandqueue;


import java.util.Scanner;
import java.util.Stack;

/*
Constraints
    1. Expression is balanced
    2. The only operators used are +, -, *, /
    3. Opening and closing brackets - () - are used to impact precedence of operations
    4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
    5. In two operators of equal precedence give preference to the one on left.
    6. All operands are single digit numbers.

Sample Input
    -+2/*6483

Sample Output
    2
    ((2+((6*4)/8))-3)
    264*8/+3-

 */
public class _11PrefixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        Stack<Integer> eval = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                eval.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");
            } else {
                int v1 = eval.pop();
                int v2 = eval.pop();
                int val = operation(v1,v2,ch);
                eval.push(val);

                String pv1 = postfix.pop();
                String pv2 = postfix.pop();
                String pval = "(" + pv1 + ch + pv2 + ")";
                postfix.push(pval);

                String iv1 = infix.pop();
                String iv2 = infix.pop();
                String ival = iv1 + iv2 + ch;
                infix.push(ival);

            }

        }
        System.out.println(eval.pop());
        System.out.println(postfix.pop());
        System.out.println(infix.pop());

    }

    private static int operation(int v1,int v2,char ch) {
        if(ch == '+') {
            return v1 + v2;
        } else if(ch == '-') {
            return v1 - v2;
        } else if(ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

}
