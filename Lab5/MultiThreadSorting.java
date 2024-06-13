package Lab5;
// Малышев Никита Евгеньевич
// группа ПРИ-О-21, вариант 1
// Работа №5, Задание 1. Обработка и запись файлов
/*
Реализовать три разных алгоритма сортировки, работающих в трёх потоках.
Все алгоритмы работают с одним массивом, т.е. нужно реализовать их синхронизацию,
таким образом: поток захватывает эту область памяти, случайным образом заполняет её, и начинает сортировать,
потом освобождает эту область памяти для других потоков. Также нужно вывести такую информацию: тип сортировки,
время старта, время окончания работы потока, время, ушедшее на сортировку.

*/
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadSorting {
    private static final int ARRAY_SIZE = 1000;
    private static final int[] array = new int[ARRAY_SIZE];
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread bubbleSortThread = new Thread(new SortTask("Пузырьковая сортировка") {
            @Override
            protected void sort(int[] array) {
                bubbleSort(array);
            }
        });

        Thread selectionSortThread = new Thread(new SortTask("Сортировка выбором") {
            @Override
            protected void sort(int[] array) {
                selectionSort(array);
            }
        });

        Thread insertionSortThread = new Thread(new SortTask("Сортировка вставками") {
            @Override
            protected void sort(int[] array) {
                insertionSort(array);
            }
        });

        bubbleSortThread.start();
        selectionSortThread.start();
        insertionSortThread.start();
    }

    abstract static class SortTask implements Runnable {
        private final String sortType;

        public SortTask(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                Random random = new Random();
                for (int i = 0; i < ARRAY_SIZE; i++) {
                    array[i] = random.nextInt(1000);
                }

                System.out.println(sortType + " началась в " + System.currentTimeMillis());

                long startTime = System.currentTimeMillis();
                sort(array);
                long endTime = System.currentTimeMillis();

                System.out.println(sortType + " закончилась в " + endTime);
                System.out.println(sortType + " заняла " + (endTime - startTime) + " мс");
            } finally {
                lock.unlock();
            }
        }

        protected abstract void sort(int[] array);

        public static void bubbleSort(int[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }

        public static void selectionSort(int[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

        public static void insertionSort(int[] array) {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
            }
        }
    }
}
