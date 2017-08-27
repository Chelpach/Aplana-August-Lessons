import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import static java.lang.String.format;

public class SecondLesson {
    /*
    ДОМАШНЕЕ ЗАДАНИЕ:

Программа состоит из трех заданий
1 Отсортировать массив произвольных чисел по убыванию и вывести его в одну строку через пробел
2 Найти в массиве чисел элементы с наибольшим(max) и наименьшим(min) значениями.
Вывести сумму этих 2-х элементов на экран
3 Найти в массиве число, которое повторяется наибольшее количество раз.

Как должна работать программа:
Программа спрашивает, какой номер задания выполнить
пользователь вводит в консоли номер задания, например 2. Запускается выполнение второго задания.
Затем, программа опят спрашивает, какой номер задания выполнить.
Опрос происходит до тех пор, пока пользователь не введет символ q.
если пользователь вводит несуществующий номер задания, например 4,
программа продолжает работу и сообщает пользователю, то такого задания нет, можно выбрать только 1,2 или 3

     */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int size = scanner.nextInt();
        int[] array = createArray(size);
        System.out.println("Первоначальный массив:");
        printArrayInLine(array);
        System.out.println();
        useMenu(array);
    }

    // запуск основного меню
    private static void useMenu(int[] array) throws IOException {
        char choice;
        System.out.println("Выберите номер задачи:");
        System.out.println("1 - сортировка по убываю и вывод в строку");
        System.out.println("2 - MAX и MIN значения, Сумма их значений");
        System.out.println("3 - Повторяющееся число в массиве");
        System.out.println("Для выхода наберите q");
        char ignore;

        do {
            choice = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
            switch (choice) {
                case '1':
                    solveFirstTask(array);
                    System.out.println();
                    System.out.println("Выберите номер задачи: 1,2,3, q-выход");
                    break;
                case '2':
                    solveSecondTask(array);
                    System.out.println();
                    System.out.println("Выберите номер задачи: 1,2,3, q-выход");
                    break;
                case '3':
                    solveThirdTask(array);
                    System.out.println();
                    System.out.println("Выберите номер задачи: 1,2,3, q-выход");
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Нет такого задания, попробуйте ввести другой номер");
            }
        } while (choice != 'q');
    }

    //решение первой задачи
    private static void solveFirstTask(int[] array) {
        if(array.length<1){
            System.out.println("Нет возможности сортировать- массив пустой.");
        }else{
            array = sortArrayFromMaxToMin(array);
            System.out.println("Упорядоченный массив: ");
            printArrayInLine(array);
        }

    }

    //решение второй задачи
    private static void solveSecondTask(int[] array) {
        if (array.length < 2) {
            System.out.println("Недостаточно значений для вычислений.");
        } else {
            array = sortArrayFromMaxToMin(array);
            System.out.println("Максимальное число в массиве = " + array[0]);
            System.out.println("Минимальное число в массиве = " + array[array.length - 1]);
            System.out.println("Сумма этих двух чисел = " + (array[0] + array[array.length - 1]));
        }
    }

    //решение третьей задачи
    private static void solveThirdTask(int[] array) {
        if (array.length<1){
            System.out.println("Нет возможности провести вычисления - массив пустой");
        }else{
            array = sortArrayFromMaxToMin(array);
            int k = 1, ktemp = 0;
            int ch = array[0], chtemp = 0;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length - 1; j++) {
                    if (array[i] == array[j]) {
                        chtemp = array[i];
                        ktemp++;
                    }
                }
                if (ktemp >= k) {
                    k = ktemp + 1;
                    ch = chtemp;
                }
                ktemp = 0;
                chtemp = 0;
            }
            if (k == 1) {
                System.out.println("Повторяющихся чисел нет.");
            } else {
                System.out.println(format("Число %s повторяется %s раз.", ch, k));
            }
        }

    }

    //Создание массива
    private static int[] createArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    //печать в строку, без пробела в конце
    private static void printArrayInLine(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (i == (array.length - 1)) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // сортировка по убыванию
    private static int[] sortArrayFromMaxToMin(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }
        }
        return array;
    }


}
