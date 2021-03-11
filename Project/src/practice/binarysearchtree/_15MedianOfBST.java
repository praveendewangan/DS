package practice.binarysearchtree;

public class _15MedianOfBST {
    // O(n),O(h)
    public static int countNodes(Node n) {
        // this function returns number of nodes in tree
        if(n==null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    public static int find(Node n, int serialNo, int target, int value[]) {
        // this function keeps track of serial number while doing
        // inorder traveresal and finds the target node
        
        if(n==null) return serialNo;
        serialNo = find(n.left, serialNo, target, value);
        
        serialNo++;
        // current value of serialNo variable is the rank of
        // current Node
        if(serialNo==target) {
            value[0] = n.data;
            return serialNo;
        }
        
        serialNo = find(n.right, serialNo, target, value);
        return serialNo;
    }

    public static void findMedian(Node root) {
        int n = countNodes(root);
        
        if(n%2!=0)
        {
            // odd number of nodes in tree:
            // 1+n/2 is the rank of mid node
            
            int mid[] = new int[1];
            mid[0] = 0;
            find( root, 0, 1+n/2, mid );
            System.out.print(mid[0]);
        }
        else
        {
            // even number of nodes in tree:
            // n/2 and 1+n/2 are the ranks of mid nodes
            
            int mid1[] = new int[1];
            int mid2[] = new int[1];
            mid1[0] = 0;
            mid2[0] = 0;
            find( root, 0, n/2, mid1 );
            find( root, 0, 1+n/2, mid2 );
            if( (mid1[0]+mid2[0])%2 == 0)
                System.out.print((mid1[0]+mid2[0])/2);
            else    
                System.out.print(((float)(mid1[0]+mid2[0])/2) );
        }
    }
}
