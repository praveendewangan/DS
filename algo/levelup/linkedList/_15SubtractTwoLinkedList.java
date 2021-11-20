import java.util.*;

class _15SubtractTwoLinkedList {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
            // printList(l1);
            // System.out.println();
            // printList(l2);
            // System.out.println();
          l1 = reverse(l1);
          l2 = reverse(l2);
          ListNode t1 = l1;
          ListNode t2 = l2;
          int b = 0;
          while(t1 != null || t2 != null || b != 0) {
              int v1 = t1 == null ? 0 : t1.val;
              int v2 = t2 == null ? 0 : t2.val;
              int dif = v1 - v2 + b;
              if(dif < 0) {
                  dif += 10;
                  b = -1;
              } else {
                  b = 0;
              }
              if(t1 != null) {
                  t1.val = dif;
                  t1 = t1.next;
              }
              if(t2 != null) {
                  t2 = t2.next;
              }
          }
          l1 = reverse(l1);
          while(l1 != null && l1.val <= 0) {
              l1 = l1.next;
          }
          return l1;
  }
  
    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static int size(ListNode node) {
      int count = 0;
      while(node != null) {
          count++;
          node = node.next;
      }
      return count;
  }
public static ListNode subtractTwoNumbers1(ListNode l1, ListNode l2) {
  int s1 = size(l1);
  int s2 = size(l2);
  ListNode t1 = null;
  ListNode t2 = null;
  if(s1 > s2){
      t1 = reverse(l1);
      t2 = reverse(l2);  
  } else {
      t1 = reverse(l2);
      t2 = reverse(l1);  
  }
  ListNode node = new ListNode(-1);
  ListNode temp = node;
  int b = 0;
  while (t1 != null || t2 != null || b != 0) {
    int v1 = t1 == null ? 0 : t1.val;
    int v2 = t2 == null ? 0 : t2.val;
    int dif = v1 - v2 + b;
    if (dif < 0) {
      dif += 10;
      b = -1;
    } else {
      b = 0;
    }
    ListNode nn = new ListNode(dif);
    temp.next = nn;
    temp = temp.next;
    if (t1 != null) {
      t1 = t1.next;
    }
    if (t2 != null) {
      t2 = t2.next;
    }
  }
  node = reverse(node.next);
  while (node != null && node.val <= 0) {
    node = node.next;
  }
  return node;
}
  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }

}