package practice.string;

public class _42PrintAllSentenceCanBeformedfromList {
    // O(n*m),O(1)
    public static void main(String[] args) {
        String [][]arr  = {{"you", "we", ""},
                            {"have", "are", ""},
                            {"sleep", "eat", "drink"}};
        print(arr,"",0,0);
    }   
    private static void print(String[][] arr,String asf,int c,int idx) {
        if(arr.length == c){
            System.out.println(asf);
            return;
        }
        for(int i=0;i<arr[0].length;i++){
            if(arr[idx][i].length() != 0){
                print(arr,asf+" "+arr[idx][i],c+1,idx+1);
            }
        }
    }
}
