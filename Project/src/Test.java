import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(br.readLine());
//        }
//        String str = br.readLine();
//        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
//        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
         quickSort(a,0,a.length-1);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
    private static void quickSort(int[] a,int lo,int hi) {
        if(lo >= hi) {
            return;
        }
        int pivot = a[hi];
        int pi = partitionArray(a,pivot,lo,hi);
        quickSort(a,lo,pi-1);
        quickSort(a,pi+1,hi);
    }
    private static int partitionArray(int[] a,int pivot,int lo,int hi) {
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if(a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j-1;
    }
    private static int[] mergeSort(int[] a,int lo,int hi) {
        int mid = (lo + hi) / 2;
        int[] la = mergeSort(a,0 , mid - 1);
        int [] ra = mergeSort(a,mid + 1,hi);
        int[] res = mergeTwoSortedArray(la,ra);
        return res;
    }
    private static int[] mergeTwoSortedArray(int[] a,int[] b) {
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        return c;
    }
    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int mi = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[mi]) {
                    mi = j;
                }
            }
            int temp = a[i];
            a[i] = a[mi];
            a[mi] = temp;
        }
    }
    private static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    private static void printNightTour(int[][] a,int row,int col,int move) {
        if(row < 0 || col < 0 || row >= a.length || col >= a[0].length || a[row][col] > 0) {
            return;
        } else if(move == a.length * a.length) {
            a[row][col] = move;
            print(a);
            a[row][col] = 0;
            return;
        }
        a[row][col] = move;
        printNightTour(a,row - 2,col + 1,move + 1);
        printNightTour(a,row - 1,col + 2,move + 1);
        printNightTour(a,row + 1,col + 2,move + 1);
        printNightTour(a,row + 2,col + 1,move + 1);
        printNightTour(a,row + 2,col - 1,move + 1);
        printNightTour(a,row + 1,col - 2,move + 1);
        printNightTour(a,row - 1,col - 2,move + 1);
        printNightTour(a,row - 2,col - 1,move + 1);
        a[row][col] = 0;
    }
    private static void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void printNQueens(int[][] a,String psf,int row) {
        if(row == a.length) {
            System.out.println(psf);
            return;
        }
        for (int col = 0; col < a.length; col++) {
            if(isQueenSafe(row,col,a)) {
                a[row][col] = 1;
                printNQueens(a,psf+row+"-"+col+",",row+1);
                a[row][col] = 0;
            }
        }
    }
    private static boolean isQueenSafe(int row,int col,int[][] a) {
        for (int i = row - 1,j=col; i >= 0; i--) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1,j=col-1; i >= 0 && j >=0; i--,j--) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1,j=col+1; i >= 0 && j < a.length; i--,j++) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    private static void printTargetSubsetSum(int[] a,int idx,int t,int sum,String asf) {
        if(t == sum) {
            System.out.println(asf);
            return;
        }
        if(idx == a.length) {
            return;
        }
        printTargetSubsetSum(a,idx+1,t,sum+a[idx],asf+a[idx]+",");
        printTargetSubsetSum(a,idx+1,t,sum,asf+"");
    }

    private static void floodFill(int a[][],int row,int col,String asf,boolean[][] visited) {
        if(row < 0 || col < 0 || row == a.length || col == a[0].length
                || a[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        if(row == a.length-1 && col == a[0].length-1){
            System.out.println(asf);
            return;
        }
        visited[row][col] = true;
        floodFill(a,row-1,col,asf+"t",visited);
        floodFill(a,row,col-1,asf+"l",visited);
        floodFill(a,row+1,col,asf+"d",visited);
        floodFill(a,row,col+1,asf+"r",visited);
        visited[row][col] = false;
    }
    private static void printEncoding(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        } else if(str.length() == 1) {
            char ch = str.charAt(0);
            if(ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                asf += code;
                System.out.println(asf);
            }
        } else {
            char ch = str.charAt(0);
            String ss = str.substring(1);
            if(ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncoding(ss,asf+code);
            }
            String ch12 = str.substring(0,2);
            String roq = str.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncoding(roq,asf+code);
            }
        }

    }
    private static void printPermutation(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ss = str.substring(0,i) + str.substring(i+1);
            printPermutation(ss,asf+ch);
        }
    }
    private static void printMazePathsJump(int sr,int sc,int dr ,int dc,String asf) {
        if(sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }
        for (int ms = 1; ms+sc <= dc; ms++) {
            printMazePathsJump(sr,sc+ms,dr,dc,asf+"h"+ms);
        }
        for (int ms = 1; ms+sr <= dr; ms++) {
            printMazePathsJump(sr+ms,sc,dr,dc,asf+"v"+ms);
        }
        for (int ms = 1; ms+sr <= dr && ms+sc <= dc; ms++) {
            printMazePathsJump(sr+ms,sc+ms,dr,dc,asf+"d"+ms);
        }
    }
    private static void printMazePaths(int sr,int sc,int dr ,int dc,String asf) {
        if(sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        } else if(sr > dr || sc > dc) {
            return;
        }
        printMazePaths(sr,sc+1,dr,dc,asf + "h");
        printMazePaths(sr+1,sc,dr,dc,asf + "v");
    }
    private static void printStairPaths(int n, String asf) {
        if(n == 0) {
            System.out.println(asf);
            return;
        } else if(n < 0) {
            return;
        }
        printStairPaths(n-1,asf + 1);
        printStairPaths(n-2,asf + 2);
        printStairPaths(n-3,asf + 3);
    }
    static String[] a = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static void printKpd(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        String key = a[ch - '0'];
        for (int i = 0; i < key.length(); i++) {
            char cho = key.charAt(i);
            printKpd(ss,asf + cho);
        }
    }
    private static void printSubSequence(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        printSubSequence(ss,asf+ch);
        printSubSequence(ss,asf+"");
    }
    private static List<String> getMazeJumpPath(int sr,int sc,int dr ,int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> paths = new ArrayList<>();
        for (int ms = 1; ms+sc <= dc; ms++) {
            List<String> hpaths = getMazeJumpPath(sr,sc+ms,dr,dc);
            for (String s : hpaths) {
                paths.add("h"+ms+s);
            }
        }
        for (int ms = 1; ms+sr <= dr; ms++) {
            List<String> vpaths = getMazeJumpPath(sr+ms,sc,dr,dc);
            for (String s : vpaths) {
                paths.add("v"+ms+s);
            }
        }
        for (int ms = 1; ms+sr <= dr && ms+sc <= dc; ms++) {
            List<String> dpaths = getMazeJumpPath(sr+ms,sc+ms,dr,dc);
            for (String s : dpaths) {
                paths.add("d"+ms+s);
            }
        }
        return paths;
    }
    private static List<String> getMazePath(int sr,int sc,int dr ,int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> hpaths = new ArrayList<>();
        List<String> vpaths = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        if(sc < dc) {
            hpaths = getMazePath(sr,sc+1,dr,dc);
        }
        if(sr < dr) {
            vpaths = getMazePath(sr+1,sc,dr,dc);
        }
        for (String s : hpaths) {
            paths.add("h"+s);
        }
        for (String s : vpaths) {
            paths.add("v"+s);
        }
        return paths;
    }
    private static List<String> getStairPath(int n) {
        if(n == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        } else if(n < 0) {
            List<String> list = new ArrayList<>();
            return list;
        }
        List<String> path1 = getStairPath(n-1);
        List<String> path2 = getStairPath(n-2);
        List<String> path3 = getStairPath(n-3);
        List<String> list = new ArrayList<>();
        for (String s : path1) {
            list.add(1 + s);
        }
        for (String s : path2) {
            list.add(2 + s);
        }
        for (String s : path3) {
            list.add(3 + s);
        }
        return list;
    }
    private static String getKeyValue(int idx){
        String[] a = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
        return a[idx];
    }
    private static List<String> getKeyPad(String str) {
        if(str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        String ch = str.substring(0,1);
        String ss = str.substring(1);
        List<String> res = getKeyPad(ss);
        List<String> list = new ArrayList<>();
        String pad = getKeyValue(Integer.parseInt(ch));
        for (int i = 0; i < pad.length(); i++) {
            char c = pad.charAt(i);
            for (String s : res) {
                list.add(c + s);
            }
        }
        return list;
    }
    private static List<String> getSeq(String str) {
        if(str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        List<String> res = getSeq(ss);
        List<String> list = new ArrayList<>();
        for (String s : res) {
            list.add(s);
        }
        for (String s : res) {
            list.add(ch + s);
        }
        return list;
    }
    private static void find(int[] a,int idx,int x) {
        if(idx == a.length) return;
        if(a[idx] == x){
            System.out.println(idx);
        }
        find(a,idx+1,x);
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static int factorial(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
