import java.util.Scanner;

public class Queen {
    public static char[][] chest = {
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'}
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findQueenposition(0);
    }

    public static void findQueenposition(int row) {
        if (row == 8) {
            printSolution();
        }else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenposition(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }
    public static void putQueen(int row, int col) {
        chest[row][col] = '*';
    }


    public static void removeQueen(int row, int col) {
        chest[row][col] = '-';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < 8; c++) {
            if (chest[row][c] == '*') {
                return false;
            }
        }
        for (int r = 0; r < 8; r++) {
            if (chest[r][col] == '*') {
                return false;
            }
        }
        int r = row;  int c = col;
        while (r >= 0 && c >= 0) {
            if (chest[r--][c--] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (r <  8 && c < 8) {
            if (chest[r++][c++] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (r >= 0 && c < 8) {
            if (chest[r--][c++] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (r < 8 && c >= 0) {
            if (chest[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }

    public static void printSolution() {
        for (char[] characters: chest) {
            for (char symbol: characters) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
