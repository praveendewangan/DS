package practice.binarytree;

public class _28LargestSubTreeSum {
    // O(n),O(n)
    static int maxVal = 0;
    public static void main(String[] args) {
        Node root = new Node(1);  
        root.left = new Node(2);  
        root.right = new Node(3);  
        root.left.left = new Node(4);  
        root.left.right = new Node(5);  
        root.right.left = new Node(6);  
        root.right.right = new Node(7);  

        findLargestSubtreeSum(root);
        System.out.println(maxVal);
    }
    public static int findLargestSubtreeSum(Node node) {
        if(node == null){
            return 0;
        }
        int ls = findLargestSubtreeSum(node.left);
        int rs = findLargestSubtreeSum(node.right);
        int sum = node.data+ls+rs;
        if(sum > maxVal){
            maxVal = sum;
        }
        return sum;
    }
}
