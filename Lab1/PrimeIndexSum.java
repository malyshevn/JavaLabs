package Lab1;
// Малышев Никита Евгеньевич
// группа ПРИ-О-21, вариант 11
// Работа №1. Введение в программирование на языке Java, задание 1
/*
11. Задана последовательность N чисел (вводится с клавиатуры). Вычислить сумму чисел, порядковые
номера которых являются простыми числами.
*/

import java.util.Scanner;

public class PrimeIndexSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос у пользователя на ввод размера последовательности N
        System.out.print("Введите размер последовательности N: ");
        int size = scanner.nextInt();

        // Создание массива размером N и заполнение его введенными числами
        int[] sequence = new int[size];
        System.out.println("Введите элементы последовательности:");
        for (int i = 0; i < size; i++) {
            sequence[i] = scanner.nextInt();
        }

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(sequence);

        // Вычисление суммы чисел с простыми порядковыми номерами
        int primeIndexSum = calculatePrimeIndexSum(sequence);

        // Вывод суммы чисел с простыми порядковыми номерами
        System.out.println("Сумма чисел с простыми порядковыми номерами: " + primeIndexSum);

        scanner.close();
    }

    // Метод для вывода массива
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод для проверки, является ли число простым
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Метод для вычисления суммы чисел с простыми порядковыми номерами
    public static int calculatePrimeIndexSum(int[] array) {
        int sum = 0;
        for (int i = 2; i < array.length; i++) { // Начинаем с 2, так как 0 и 1 не являются простыми номерами
            if (isPrime(i)) {
                sum += array[i];
            }
        }
        return sum;
    }
}
