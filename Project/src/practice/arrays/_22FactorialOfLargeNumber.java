package practice.arrays;

import java.util.Scanner;

public class _22FactorialOfLargeNumber {
    static class Node {
        int data;
        Node prev;
        Node(int data) {
            this.data = data;
            this.prev = null;
        }
    }
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        int n = 1;
		for(int i = 0; i < n; i++){
            // int num = scn.nextInt();
            int num = 5;
    		Node tail = new Node(1);
    		for(int j = 2; j <= num;j++)
        		multiply(tail,j);
        	print(tail);
            System.out.println();
    // 		int f = fact(num,m);
		  //  System.out.println(f);
		}
	}
	static void print(Node tail) {
	    if(tail == null)
	        return;
	   print(tail.prev);
	   System.out.print(tail.data);
	}
	
	static void multiply(Node tail,int n) {
	    Node temp = tail, prevNode = tail;
	    int carry = 0;
	    while(temp != null) {
	        int data = temp.data * n + carry;
	        temp.data = data % 10;
	        carry = data / 10;
	        prevNode = temp;
	        temp = temp.prev;
	    }
	    while(carry != 0 ) {
	        prevNode.prev = new Node((int) (carry % 10));
	        carry /= 10;
	        prevNode = prevNode.prev;
	    }
	}
	
	public static int fact(int n,int[] m) {
	    if(n == 0) {
	        return 1;
	    }
	    if(n == 1 || n == 2){
	        return n;
	    }
	    if(m[n] != 0){
	        return m[n];
	    }
	    
	    int f = n * fact(n-1,m);
	    m[n] = f;
	    return f;
	}
}