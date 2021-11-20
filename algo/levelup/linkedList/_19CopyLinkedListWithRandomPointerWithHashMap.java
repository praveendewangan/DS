import java.util.*;

class _19CopyLinkedListWithRandomPointerWithHashMap {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = new ListNode(-1);
        ListNode temp = t2;
        while(t1 != null) {
            ListNode nn = new ListNode(t1.val);
            temp.next = nn;
            temp = temp.next;
            t1 = t1.next;
        }
        
        t1 = head;
        t2 = t2.next;
        
        Map<ListNode,ListNode> mp = new HashMap<>();
        ListNode n1 = t1;
        ListNode n2 = t2;
        
        while(n1 != null) {
            mp.put(n1,n2);
            n1 = n1.next;
            n2 = n2.next;
        }
        
        for(ListNode oNode : mp.keySet()) {
            ListNode cNode = mp.get(oNode);
            ListNode oRandom = oNode.random;
            
            if(oRandom != null) {
                cNode.random = mp.get(oRandom);
            }
        }
        
        
        return t2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}