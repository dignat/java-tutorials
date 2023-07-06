import java.util.Scanner;
public class CombinationsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        int binomNumber = binom(n, k);
        System.out.println(binomNumber);
    }
    // pascal's triangle
    public static int binom(int row , int index) {
        if (index > row) {
            return 0;
        }
        if (index == 0 || index == row) {
            return 1;
        }
        return binom(row-1, index-1) + binom(row-1, index);
    }
}
