// Малышев Никита Евгеньевич
// группа ПРИ-О-21, вариант 11
// Работа №2. Обработка и запись файлов
/*
11. Записать в результирующий файл все самое длинное и самое короткое слово в каждой строке
*/
package Lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FindMinMaxWords {

    public static void main(String[] args) {
        // Имя входного и выходного файлов
        String inputFileName = "gore-ot-uma.txt";
        String outputFileName = "min_max_words.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Разделение строки на слова
                StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f,.:;?![]'\"—");

                List<String> words = new ArrayList<>();

                // Сбор всех слов в строке
                while (tokenizer.hasMoreTokens()) {
                    String currentWord = tokenizer.nextToken();

                    // Убедимся, что слово состоит только из букв
                    if (currentWord.matches("[a-zA-Zа-яА-Я]+")) {
                        words.add(currentWord);
                    }
                }

                if (!words.isEmpty()) {
                    // Находим самое короткое и самое длинное слово в списке
                    String shortestWord = Collections.min(words, (s1, s2) -> s1.length() - s2.length());
                    String longestWord = Collections.max(words, (s1, s2) -> s1.length() - s2.length());

                    // Запись самого короткого и самого длинного слов в файл на одной строке через пробел
                    writer.write(shortestWord + " " + longestWord);
                }

                // Переход на новую строку
                writer.newLine();
            }

            System.out.println("Результат сохранен в " + outputFileName);

        } catch (IOException e) {
            System.err.println("Ошибка чтения или записи: " + e.getMessage());
        }
    }
}
