package recursion;

public class PrintKnightTour {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        printTour(arr,2,3,1);

    }
    private static void printTour(int[][] arr,int row,int col,int move) {
        if(row < 0 || col < 0 || row >= arr.length || col >= arr.length || arr[row][col] > 0) {
            return;
        } else if(move == arr.length * arr.length) {
            arr[row][col] = move;
            print(arr);
            arr[row][col] = 0;
        }
        arr[row][col] = move;
        printTour(arr,row - 2,col + 1,move + 1);
        printTour(arr,row - 1,col + 2,move + 1);
        printTour(arr,row + 1,col + 2,move + 1);
        printTour(arr,row + 2,col + 1,move + 1);
        printTour(arr,row + 2,col - 1,move + 1);
        printTour(arr,row + 1,col - 2,move + 1);
        printTour(arr,row - 1,col - 2,move + 1);
        printTour(arr,row - 2,col - 1,move + 1);
        arr[row][col] = 0;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
