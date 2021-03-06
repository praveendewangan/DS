package practice.binarytree;

public class _17ConstructBinaryTreeFromString {
    static int start = 0;
    public static void main(String[] args) {
        String str = "-4(2(3)(1))(6(5))";
        Node node = constructTree(str);
    }
    public static Node constructTree(String s) {
        if(start >= s.length()) {
            return null;
        }
        boolean neg = false;
        if(s.charAt(start) == '-') {
            neg = true;
            start++;
        }
        int num = 0;//constructing integer from string
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = (int) (s.charAt(start) - '0');
            num = num * 10 + digit;
            start++;
        }
        if(neg) num = -num;
        Node node = new Node(num);
        if(start >= s.length()) return node;

        if(start < s.length() && s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }

        if(start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        if(start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }

        if(start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        return node;
    }
}
