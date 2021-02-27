package practice.linkedlist;

public class _30MultiplyTwoLinkedList {
    // O(n),O(1)
    public long multiplyTwoLists(Node l1,Node l2){
        long n1 = 0;
        long n2 = 0;
        long mod=1000000007L;
      while(l1 != null || l2 != null) {
          if(l1 != null) {
              n1 = ((n1*10)%mod + l1.data%mod)%mod;
              l1 = l1.next;
          }
          if(l2 != null) {
              n2 = ((n2*10)%mod + l2.data%mod)%mod;
              l2 = l2.next;
          }
      }
      return ((n1%mod)*(n2%mod))%mod;
}
}
