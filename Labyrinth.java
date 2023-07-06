import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Labyrinth {
  public static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 3;
        int cols = 5;

        char[][] labyrinth = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }
        findPath(labyrinth, 0, 0, ' ');
    }

    public static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if (!isInBounds(labyrinth, row, col) || labyrinth[row][col] == 'V' || labyrinth[row][col] == '*')  {
            return;
        }
        path.add(direction);
        if (labyrinth[row][col] == 'e') {
            printPath();
            path.remove(path.size() - 1);
            return;
        }
        labyrinth[row][col] = 'V';
        findPath(labyrinth, row-1, col, 'U');
        findPath(labyrinth, row+1, col, 'D');
        findPath(labyrinth, row, col-1, 'L');
        findPath(labyrinth, row, col+1, 'R');
        labyrinth[row][col] = '-';
        path.remove(path.size() - 1);
    }

    public static boolean isInBounds(char[][] labyrint, int row, int col) {
        return row < labyrint.length && row >= 0 && col < labyrint[row].length && col >= 0;
    }

    public static void printPath() {
        for (Character character: path) {
            System.out.print(character);
        }
        System.out.println();
    }


}
