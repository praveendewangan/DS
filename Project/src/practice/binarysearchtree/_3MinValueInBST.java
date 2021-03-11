package practice.binarysearchtree;

public class _3MinValueInBST {
    // O(h),O(1)
    int minValue(Node node)
    {
        if(node == null) {
            return -1;
        }
        if(node.left == null){
            return node.data;
        }
        return minValue(node.left);
    }
}
