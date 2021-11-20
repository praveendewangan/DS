import java.util.*;

class _26SegregateNodeOfLinkedlistOverPivotIndex {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
      ListNode temp = head;
      ListNode pivot = null;
      for(int i = 0; i <= pivotIdx; i++) {
          pivot = temp;
          temp = temp.next;
      }
      
      ListNode smaller = new ListNode(-1);
      ListNode t1 = smaller;
      ListNode greater = new ListNode(-1);
      ListNode t2 = greater;
      temp = head;
      while(temp != null) {
          if(temp != pivot) {
              if(temp.val <= pivot.val) {
                  t1.next = temp;
                  t1 = temp;
              } else {
                  t2.next = temp;
                  t2 = temp;
              }
          }
              temp = temp.next;
      }
      t1.next = null;
      t2.next = null;
      
      pivot.next = greater.next;
      t1.next = pivot;
    return smaller.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}