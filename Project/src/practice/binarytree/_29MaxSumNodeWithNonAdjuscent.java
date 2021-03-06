package practice.binarytree;

import java.util.HashMap;
import java.util.Map;

public class _29MaxSumNodeWithNonAdjuscent {
    // O(n),O(n)
    Map<Node,Integer> dp = new HashMap<>();
    public int maxSum(Node node) {
        if(node == null){
            return 0;
        }
        if(dp.containsKey(node)) return dp.get(node);
        int inc = node.data;
        if(node.left != null) {
            inc += maxSum(node.left.left);
            inc += maxSum(node.left.right);
        }
        if(node.right != null) {
            inc += maxSum(node.right.left);
            inc += maxSum(node.right.right);
        }
        int exc = maxSum(node.left) + maxSum(node.right);
        dp.put(node, Math.max(inc,exc));
        return dp.get(node);

    }
}
