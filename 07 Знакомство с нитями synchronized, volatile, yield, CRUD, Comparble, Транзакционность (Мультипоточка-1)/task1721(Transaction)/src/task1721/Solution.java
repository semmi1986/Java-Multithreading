package task1721;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Requirements:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Считываем имена файлов с консоли
            System.out.println("enter name 1 file ");
            String file1 = scanner.nextLine();
            System.out.println("enter name 2 file ");
            String file2 = scanner.nextLine();

            // Считываем данные из файлов
            try {
                readLinesFromFile(file1, allLines);
                readLinesFromFile(file2, forRemoveLines);
            } catch (IOException e) {
                System.out.println("error reading files: " + e.getMessage());
                return; // Прерываем выполнение, если возникла ошибка при чтении файлов
            }

            // Выполняем транзакцию joinData
            try {
                joinData();
                System.out.println("Data successfully joined.");
            } catch (CorruptedDataException e) {
                System.out.println("Data corrupted: " + e.getMessage());
            }
        } finally {
            scanner.close();
        }
    }

    private static void readLinesFromFile(String filename, List<String> list) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
    }

    public static void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException("Not all lines from 'forRemoveLines' are present in 'allLines'.");
        }
    }
}
