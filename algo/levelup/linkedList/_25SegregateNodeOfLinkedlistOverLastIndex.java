import java.util.*;

class _25SegregateNodeOfLinkedlistOverLastIndex {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregateOnLastIndex(ListNode head) {

    ListNode temp = head;
    ListNode pivot = null;
    while(temp != null) {
      pivot = temp;
      temp = temp.next;
    }

    ListNode greater = new ListNode(-1);
    ListNode t1 = greater;
    temp = head;
    while (temp != null) {
      if (temp != pivot && temp.val > pivot.val) {
          t1.next = temp;
          t1 = temp;
      }
      temp = temp.next;
    }
    t1.next = null;

    pivot.next = greater.next;
    return pivot;
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
    h1 = segregateOnLastIndex(h1);
    printList(h1);
  }
}