package backtrackingwithrecursion;

public class SolveCrossworldPuzzle extends DisplayArray{
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        char[][] a = null;
        String[] words = null;
        solve(a,words,0);
    }

    private static void solve(char[][] a,String[] words,int idx) {
        if(idx == words.length){
            printArray(a);
            return;
        }
        String word = words[idx];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == '-' || a[i][j] == word.charAt(0)) {
                    if(canPlaceHorizontally(a,word,i,j)) {
                        boolean[] wePlaced = placeHorizontally(a,word,i,j);
                        solve(a,words,idx + 1);
                        unplaceHorizontally(a,wePlaced,i,j);
                    }
                    if(canPlaceVertically(a,word,i,j)) {
                        boolean[] wePlaced = placeVertically(a,word,i,j);
                        solve(a,words,idx + 1);
                        unplaceVertically(a,wePlaced,i,j);
                    }
                }
            }
        }
    }

    private static boolean canPlaceHorizontally(char[][] a,String word,int i,int j) {
        if(j-1 >= 0 && a[i][j-1] != '+') {
            return false;
        } else if (j + word.length() < a[0].length && a[i][j + word.length()] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if(j + k >= a[0].length) {
                return false;
            }
            if(a[i][j+k] == '-' || a[i][j+k] == word.charAt(k)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canPlaceVertically(char[][] a,String word,int i,int j) {
        if(i-1 >= 0 && a[i-1][j] != '+') {
            return false;
        } else if (i + word.length() < a.length && a[i + word.length()][j] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if(i + k >= a.length) {
                return false;
            }
            if(a[i + k ][j] == '-' || a[i + k][j] == word.charAt(k)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean[] placeHorizontally(char[][] a,String word,int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (a[i][j+k] == '-') {
                a[i][j+k] = word.charAt(k);
                wePlaced[k] = true;
            }
        }
        return wePlaced;
    }

    private static void unplaceHorizontally(char[][] a,boolean[] wePlaced,int i,int j) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k] == true) {
                a[i][j+k] = '-';
            }
        }
    }


    private static boolean[] placeVertically(char[][] a,String word,int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (a[i + k][j] == '-') {
                a[i+k][j] = word.charAt(k);
                wePlaced[k] = true;
            }
        }
        return wePlaced;
    }

    private static void unplaceVertically(char[][] a,boolean[] wePlaced,int i,int j) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k] == true) {
                a[i+k][j] = '-';
            }
        }
    }
}
