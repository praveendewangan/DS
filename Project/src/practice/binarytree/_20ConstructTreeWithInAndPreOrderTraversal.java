package practice.binarytree;

public class _20ConstructTreeWithInAndPreOrderTraversal {
    // O(nlogn),O(1)
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return helper(inorder,preorder,0,n-1,0,n-1);
    }
    public static Node helper(int inorder[], int preorder[],int inStart,int inEnd,int preStart,int preEnd) {
        if(inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        Node node = new Node(val);
        int rootIdx = inStart;
        for(;rootIdx < inEnd;rootIdx++){
            if(inorder[rootIdx] == val) break;
        }
        int leftTreeSize = rootIdx - inStart;
        int rightTreeSize = inEnd - rootIdx;
        node.left = helper(inorder,preorder,inStart,rootIdx-1,preStart+1,preEnd-leftTreeSize+1);
        node.right = helper(inorder,preorder,rootIdx+1,inEnd,preStart+leftTreeSize+1,preEnd);
        return node;
    }
}
