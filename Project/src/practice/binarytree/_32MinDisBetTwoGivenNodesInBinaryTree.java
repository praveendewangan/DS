package practice.binarytree;

public class _32MinDisBetTwoGivenNodesInBinaryTree {
    // O(n),O(h)
    int findDist(Node root, int a, int b) {
        Node lca = lca(root,a,b);
        if(lca == null) {
            return -1;
        }
        int d1 = getDistance(lca,a,0);
        int d2 = getDistance(lca,b,0);
        return d1+d2;
     }
     Node lca(Node node,int n1,int n2) {
         if(node == null) {
             return null;
         }
         if(node.data == n1 || node.data == n2) {
             return node;
         }
         Node left = lca(node.left,n1,n2);
         Node right = lca(node.right,n1,n2);
         if(left != null && right != null) {
             return node;
         }
         return left != null ? left : right;
     }
     int getDistance(Node node,int n,int d) {
         if(node == null) return -1;
         if(node.data == n) return d;
         int distance = getDistance(node.left,n,d+1);
         if(distance != -1) return distance;
         distance = getDistance(node.right,n,d+1);
         return distance;
     }
}
