import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число Х");
        int x = scanner.nextInt();
        System.out.println("Введите число Y");
        int y = scanner.nextInt();
        System.out.println("Числитель = " + solveNumerator(x, y));
        System.out.println("Знаменатель = " + solveDenumerator(x));
        System.out.println("Решение уравнения = " + solveEquation(solveNumerator(x, y), solveDenumerator(x)));

    }

    private static int solveNumerator(int x, int y) {
        return 3 * (x + 2 * x - y);
    }

    private static int solveDenumerator(int x) {
        return 2 * x;
    }

    private static double solveEquation(double numerator, double denumerator) {
        return numerator / denumerator;
    }

}