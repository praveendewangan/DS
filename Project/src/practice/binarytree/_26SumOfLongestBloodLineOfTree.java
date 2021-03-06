package practice.binarytree;

public class _26SumOfLongestBloodLineOfTree {
    // O(n),O(1)
    int maxLen = 0;
    int maxSum = 0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        helper(root,0,0);
        return maxSum;
    }
    
    void helper(Node node,int sum,int len) {
        if(node == null) {
            if(maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if(maxLen == len && maxSum < sum) {
                maxSum = sum;
            }
            return;
        }
        helper(node.left,sum+node.data,len+1);
        helper(node.right,sum+node.data,len+1);
    }
}
