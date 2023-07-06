public class Fibo {
    public static void main(String[] args) {
        System.out.println(calculateFibo(5));
        drawFigure(5);
    }

    public static long calculateFibo(int n) {
        if (n==0) {
            return 1;
        }
        return n * calculateFibo(n -1);
    }

    public static void drawFigure(int n) {
        // preaction
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print('*');
        }
        System.out.println();
        // recirsive call
        drawFigure(n-1);

        // post action
        for (int i = 0; i < n; i++) {
            System.out.print('#');
        }
        System.out.println();
    }
}
