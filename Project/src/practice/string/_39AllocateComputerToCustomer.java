package practice.string;

public class _39AllocateComputerToCustomer {
    // O(n),O(256)
    public static void main(String[] args) {
        String str = "ABCBCA";
        int n = 1;

        int[] arr = new int[256];
        int didnotget = 0;
        int occupied = 0;

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(arr[ch - 'A'] == 0 && occupied < n) {
                arr[ch - 'A'] = 1;
                occupied++;
            } else if(arr[ch - 'A'] == 1 && occupied <= n){
                occupied--;
                arr[ch - 'A'] = 0;
            } else {
                didnotget++;
            }
        }
        System.out.println(didnotget/2);
    }
}
