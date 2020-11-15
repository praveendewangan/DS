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
    264*8/+3-

Sample Output
    2
    ((2+((6*4)/8))-3)
    -+2/*6483

 */
public class _10PostfixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        Stack<Integer> eval = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                eval.push(ch - '0');
                infix.push(ch+"");
                prefix.push(ch+"");
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = eval.pop();
                int v1 = eval.pop();
                eval.push(opeeration(v1,v2,ch));
                String iv2 = infix.pop();
                String iv1 = infix.pop();
                String iVal = "("+ iv1 + ch + iv2 + ")";
                infix.push(iVal);

                String pv2 = prefix.pop();
                String pv1 = prefix.pop();
                String pVal = ch + pv1 +  pv2;
                prefix.push(pVal);
            }
        }
        System.out.println(eval.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    }

    private static int opeeration(int v1,int v2,char ch) {
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
