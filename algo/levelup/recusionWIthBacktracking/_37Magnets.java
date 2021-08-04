import java.io.*;
import java.util.*;

public class _37Magnets {

public static int signCountInRow(char[][] ans, int row, char sign) {
        int count = 0;
        for(int c = 0; c < ans[0].length; c++) {
            if(ans[row][c] == sign) {
                count++;
            }
        }
        return count;
    }

    public static int signCountInCol(char[][] ans, int col, char sign) {
        int count = 0;
        for(int r = 0; r < ans.length; r++) {
            if(ans[r][col] == sign) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValid(char[][] ans, int[] top, int[] left, int[] right, 
        int[] bottom, int r, int c, char sign) {
        // make a check for valid polarity
        int[] xdir = {-1,0,0};
		int[] ydir = {0,1,-1};
        for(int d = 0; d < 3; d++) {
            int rr = r + xdir[d];
            int cc = c + ydir[d];
            if(rr >= 0 && rr < ans.length && cc >= 0 && cc < ans[0].length && ans[rr][cc] == sign) {
                return false;
            }
        }
        // make a check for valid sign count in row and col
        int cir = signCountInRow(ans, r, sign); // cir -> count in row
        int cic = signCountInCol(ans, c, sign); // cic -> count in column

        // top and left -> +ve sign, bottom ans right -> -ve sign
        if(sign == '+') {
            if((top[c] != -1 && cic >= top[c]) || (left[r] != -1 && cir >= left[r])) {
                return false;
            }
        } else {
            if((bottom[c] != -1 && cic >= bottom[c]) || (right[r] != -1 && cir >= right[r])) {
                return false;
            }
        }
        return true;
    }
        
    public static boolean isCorrectResult(char[][] ans, int[] top, int[] left, int[] bottom, int[] right) {
        // check for row
        for(int r = 0; r < ans.length; r++) {
            int pcount = 0; // positive count
            int ncount = 0; // negative count
            for(int c = 0; c < ans[0].length; c++) {
                if(ans[r][c] == '+') pcount++;
                else if(ans[r][c] == '-') ncount++;
            }
            if(left[r] != -1 && left[r] != pcount) return false;
            if(right[r] != -1 && right[r] != ncount) return false;
        }
        // check for col
        for(int c = 0; c < ans[0].length; c++) {
            int pcount = 0; // positive count
            int ncount = 0; // negative count
            for(int r = 0; r < ans.length; r++) {
                if(ans[r][c] == '+') pcount++;
                else if(ans[r][c] == '-') ncount++;
            }
            if(top[c] != -1 && top[c] != pcount) return false;
            if(bottom[c] != -1 && bottom[c] != ncount) return false;
        }
        return true;
    }

        
    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, 
                                    char[][] ans, int row, int col) {
        if(col == arr[0].length) {
            col = 0;
            row++;
        }
        if(row == ans.length) {
            if(isCorrectResult(ans, top, left, bottom, right))
                return true;
            else
                return false;
        }
        // yes call
        if(arr[row][col] == 'L') {
            // [L | R] -> + -
            if(isValid(ans, top, left, right, bottom, row, col, '+') && 
            isValid(ans, top, left, right, bottom, row, col + 1, '-')) {
                // place + -
                ans[row][col] = '+';
                ans[row][col + 1] = '-';
                if(solution(arr, top, left, right, bottom, ans, row, col + 2) == true) {
                    return true;
                }
                // unplace + -
                ans[row][col] = 'X';
                ans[row][col + 1] = 'X';
            }
            // [L | R] -> - +
            if(isValid(ans, top, left, right, bottom, row, col, '-') && 
            isValid(ans, top, left, right, bottom, row, col + 1, '+')) {
                // place - +
                ans[row][col] = '-';
                ans[row][col + 1] = '+';
                if(solution(arr, top, left, right, bottom, ans, row, col + 2) == true) {
                    return true;
                }
                // unplace - +
                ans[row][col] = 'X';
                ans[row][col + 1] = 'X';
            }
        } else if(arr[row][col] == 'T') {
            // [T | B] -> + -
            if(isValid(ans, top, left, right, bottom, row, col, '+') && 
            isValid(ans, top, left, right, bottom, row + 1, col, '-')) {
                // place + -
                ans[row][col] = '+';
                ans[row + 1][col] = '-';
                if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true) {
                    return true;
                }
                // unplace + -
                ans[row][col] = 'X';
                ans[row + 1][col] = 'X';
            }
            // [T | B] -> - +
            if(isValid(ans, top, left, right, bottom, row, col, '-') && 
            isValid(ans, top, left, right, bottom, row + 1, col, '+')) {
                // place - +
                ans[row][col] = '-';
                ans[row + 1][col] = '+';
                if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true) {
                    return true;
                }
                // unplace - +
                ans[row][col] = 'X';
                ans[row + 1][col] = 'X';
            }
        }
        // no call
        if(solution(arr, top, left, right, bottom, ans, row, col + 1)) {
            return true;
        }
		return false;
	}
	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = scn.nextInt();
		}
		int[] left = new int[m];
		for (int i = 0; i < m; i++) {
			left[i] = scn.nextInt();
		}
		int[] right = new int[m];
		for (int i = 0; i < m; i++) {
			right[i] = scn.nextInt();
		}
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
			bottom[i] = scn.nextInt();
		}

		//write your code here
		char[][] ans = new char[m][n];
		for(int i=0; i < m; i++){
		    for(int j=0; j < n; j++) {
		        ans[i][j] = 'X';
		    }
		}
		if(solution(arr,top,left,right,bottom,ans,0,0)) {
		    print(ans);
		} else {
		    System.out.println("No Solution");
		}
	}

	
}