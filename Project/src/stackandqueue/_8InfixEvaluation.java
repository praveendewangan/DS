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
    2 + 6 * 4 / 8 - 3

Sample Output
    2
 */
public class _8InfixEvaluation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                operators.push(ch);
            } else if(Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if(ch == ')') {
                while (operators.peek() != '(') {
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int val = operation(v1,v2,optor);
                    operands.push(val);
                }
                operators.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int val = operation(v1,v2,optor);
                    operands.push(val);
                }
                operators.push(ch);
            }
        }

        while (operators.size() != 0) {
            char optor = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int val = operation(v1,v2,optor);
            operands.push(val);
        }
        System.out.println(operands.peek());
    }
    private static int operation(int v1,int v2,char operator) {
        if(operator == '+') {
            return v1 + v2;
        } else if(operator == '-') {
            return v1 - v2;
        } else if(operator == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
    private static int precedence(char operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
