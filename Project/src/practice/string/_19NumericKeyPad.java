package practice.string;

public class _19NumericKeyPad {
    public static void main(String[] args) {
        String str[] = {"2","22","222", 
                        "3","33","333", 
                        "4","44","444", 
                        "5","55","555", 
                        "6","66","666", 
                        "7","77","777","7777", 
                        "8","88","888", 
                        "9","99","999","9999"
                    }; 
        String input = "GEEKSFORGEEKS";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == ' ') {
                sb.append("0");
            } else {
                int j = input.charAt(i) - 'A';
                sb.append(str[j]);
            }
        }
        System.out.println(sb.toString());
    }
}
