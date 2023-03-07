import java.util.ArrayList;

public class EightQueensProblemSolver {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        solutions(4);
    }

    public static void solutions (int n) {
        for (int start = 0; start < n; start++) {
            String[][] arr = new String[n][n];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = "0";
                }
            }
            ArrayList<Integer> takenRows = new ArrayList<Integer>();
            ArrayList<Integer> takenColumns = new ArrayList<Integer>();
            takenRows.add(0);
            takenColumns.add(start);
            arr[0][start] = "Q";
            setXs(arr, 0, start, n);
            for (int row = 1; row < n; row++) {
                for (int col = start + 1; col < n; col++) {
                    if (arr[row][col].equals("0")) {
                        arr[row][col] = "Q";
                        setXs(arr, row, col, n);
                    }
                }
            }
            for (int row = 1; row < n; row++) {
                for (int col = start - 1; col >= 0; col--) {
                    if (arr[row][col].equals("0")) {
                        arr[row][col] = "Q";
                        setXs(arr, row, col, n);
                    }
                }
            }

            for (String[] theRow : arr) {
                for (String value : theRow) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
        }



    }

    public static void setXs (String[][] arr, int row, int col, int n) {
        for (int i = row + 1; i < arr.length; i++) {
            arr[i][col] = "X";
        }
        for (int i = row - 1; i >= 0; i--) {
            arr[i][col] = "X";
        }
        for (int j = col + 1; j < arr[0].length; j++) {
            arr[row][j] = "X";
        }
        for (int j = col - 1; j >= 0; j--) {
            arr[row][j] = "X";
        }
        int i = row + 1;
        int j = col + 1;
        while (i < n && j < n) {
            arr[i][j] = "X";
            i++;
            j++;
        }
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            arr[i][j] = "X";
            i--;
            j--;
        }
        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0) {
            arr[i][j] = "X";
            i++;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            arr[i][j] = "X";
            i--;
            j++;
        }
    }

}
