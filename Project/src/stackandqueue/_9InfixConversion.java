package stackandqueue;

/*
Constraints
    1. Expression is balanced
    2. The only operators used are +, -, *, /
    3. Opening and closing brackets - () - are used to impact precedence of operations
    4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
    5. In two operators of equal precedence give preference to the one on left.
    6. All operands are single digit numbers.

Sample Input
    a*(b-c+d)/e

Sample Output
    abc-d+*e/
    /*a+-bcde
 */

import java.util.Scanner;
import java.util.Stack;

public class _9InfixConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                operator.push(ch);
            } else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch+"");
                post.push(ch+"");
            } else if(ch == ')') {
                while (operator.peek() != '(') {
                    process(operator,pre,post);
                }
                operator.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0 && operator.peek() != '('  &&
                        precedence(ch) <= precedence(operator.peek())) {
                    process(operator,pre,post);
                }
                operator.push(ch);
            }

        }

        while (operator.size() != 0 ) {
            process(operator,pre,post);
        }
        System.out.println(" Prefix -> " + pre.pop());
        System.out.println(" Postfix -> " + post.pop());

    }

    private static void process(Stack<Character> operator , Stack<String> pre,Stack<String> post) {
        char op = operator.pop();
        String v2 = pre.pop();
        String v1 = pre.pop();
        String val = op+v1+v2;
        pre.push(val);
        v2 = post.pop();
        v1 = post.pop();
        val = v1+v2+op;
        post.push(val);
    }

    private static int precedence(char op) {
        if(op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
