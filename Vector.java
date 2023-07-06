public class Vector {
    public static void main(String[] args) {
        Integer[] memory = new Integer[3];
        fillVector(memory, 0);
    }
    public static void fillVector(Integer[] memory, int index) {
        if (index >= memory.length) {
            print(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }

    }

    public static void print(Integer[] memory) {
        for (Integer integer: memory) {
            System.out.print(integer);
        }
        System.out.println();
    }
}
