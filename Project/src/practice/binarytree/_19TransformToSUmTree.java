package practice.binarytree;

public class _19TransformToSUmTree {
    // O(n),O(1)
    public void toSumTree(Node root){
        sumTreeHelper(root);
   }
   public int sumTreeHelper(Node node) {
       if(node == null) return 0;
       int ls = sumTreeHelper(node.left);
       int rs = sumTreeHelper(node.right);
       
       int sum = node.data;
       node.data = ls+rs;
       return sum+ls+rs;
   }
}
