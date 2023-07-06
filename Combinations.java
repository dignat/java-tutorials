import java.util.Scanner;

public class Combinations {
    public static String [] variations;
    public static String [] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        variations = new String[k];
        combinationsWithRepetions(0, 0);
    }

    public static void combinations(int index, int start) {
        if (index == variations.length) {
            print(variations);
        } else {
            for (var i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i + 1);
                
            }
        }
    }
    public static void combinationsWithRepetions(int index, int start) {
        if (index == variations.length) {
            print(variations);
        } else {
            for (var i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i); // repeating the element
                
            }
        }
    }

    private static void print(String [] arr) {
        System.out.println(String.join(" ", arr));
    }
}
