package org.example.hw5.task2;
//2) Подсчитать количество искомого слова, через map (наполнением значение, где искомое слово будет являться ключом)
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner myReader = new Scanner(System.in);
        File inFile = new File("./src/main/java/org/example/hw4/task2/test.txt");
        System.out.print("Введите слово для поиска: ");
        String findWord = myReader.nextLine();
        myReader.close();
        System.out.println("Слово \"" + findWord + "\" встречается " + countWordIn(inFile, findWord.toLowerCase()) + " раз(а)");



    }

    public static int countWordIn (File inFile, String findWord) {

        Map<String, Integer> word = new HashMap<>();
        word.put(findWord, 0);

        try {
            Scanner readFile = new Scanner(inFile);

            while (readFile.hasNextLine()) {
                String str = readFile.nextLine();
                String[] split = str.toLowerCase().replaceAll("[\\p{Punct}]", "").split(" ");
                for (String w : split) {
                    if (w.equals(findWord)) {
                        word.put(findWord, word.get(findWord) + 1);
                    }
                }
            }

            readFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return word.get(findWord);
    }


}
