package practice.string;

public class _9PrintAllSubSequence {
    public static void main(String[] args) {
        String s = "abc";
        print(s,"");
    }
    public static void print(String str,String asf) {
        if(str.length() == 0) {
            System.out.print(asf + " ");
            return;
        }

        print(str.substring(1),asf+""+str.charAt(0));
        print(str.substring(1),asf+"");
    }
}
