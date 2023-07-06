public class Recurs {
    public static void main(String[] args) {
        int sum = 0;
        int[] numbersList = {1,2,3,4};
        sum = setNumbers(numbersList, 0);
        System.out.println("Recursion sum " + sum);
        sum = setNumbersTwo(numbersList, numbersList.length -1);
        System.out.println("Decrease recursion " + sum);
    }

    public static int setNumbers(int[] numbers, int index) {
        if (index >= numbers.length ) {
            return 0;
        }
        return numbers[index] +  setNumbers(numbers, index + 1);
    }
    public static int setNumbersTwo(int[] numbers, int index) {
        if (index < 0 ) {
            return 0;
        }
        return numbers[index] +  setNumbersTwo(numbers, index - 1);
    }
}
