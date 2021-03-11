package practice.binarysearchtree;

public class _1FindAValueInBST {
    // O(h),O(1)
    Node findVal(Node node,int data) {
        if(node == null || node.data == data) {
            return node;
        }
        if(node.data < data){
            return findVal(node.right, data);
        }
        return findVal(node.left, data);
    }
}
