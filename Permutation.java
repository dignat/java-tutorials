import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
public class Permutation {
    public static String[] elements;

    public static String[] permutes;
    public static String[] variations;
    public static boolean[] used;

    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        permutes = new String[elements.length];
        used = new boolean[elements.length];
        // our slots
        int k = Integer.parseInt(scanner.nextLine());
        variations = new String[k];
        numbers = new int[4];
        // for (var i = 0; i < numbers.length; i++) {
        //     numbers[i] = scanner.nextInt();
            
        // }
        Arrays.sort(numbers);
        variationWithRepetion(0);
    }

    public static void permuteRepetion(int [] arr, int start, int end) {
        printIntArray(arr);
        for (int left = end -1; left >= start; left--){
            for (int right = left + 1; right <= end; right++) {
                if (arr[left] != arr[right]) {
                    swapint(arr, left, right);
                    permuteRepetion(arr, left + 1, end);
                }
                int firstElement = arr[left];
                for (int i = left; i <= end -1; i++) {
                    arr[i] = arr[i+1];
                    arr[end] = firstElement;
                }
            }

           
        }

    }

    public static void variation(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i];
                variation(index+1);
                used[i] = false;
            }
            
        }
    }
    public static void variationWithRepetion(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
                variations[index] = elements[i];
                variation(index+1);            
        }
    }

    public static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutes[index] = elements[i];
                permute(index+1);
                used[i] = false;
            }
            
        }
    }

    public static void permuteWithnoExtraMemory(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permuteWithnoExtraMemory(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements,index, i);//swap 
            permuteWithnoExtraMemory(index + 1);
            swap(elements, index, i);//unswap from backtracking of the recursion
            
        }
    }

    public static void permuteWithoutRepetion(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permuteWithoutRepetion(index + 1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);
        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains(elements[i])) {
                swap(elements,index, i);//swap 
                permuteWithnoExtraMemory(index + 1);
                swap(elements, index, i);//unswap from backtracking of the recursion
                swapped.add(elements[i]);
            }
            
            
        }
    }


    public static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
        
    }

    public static void swapint(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
        
    }

    public static void print(String[]arr) {
        System.out.println(String.join(" " , arr));
    }
    public static void printIntArray(int [] arr) {
        for (Integer el : arr) {
            System.out.print(el);
        }
        System.out.println();
    }
}
