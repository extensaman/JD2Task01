package by.academy.it.task01;

import by.academy.it.task01.fileworker.FileWorker;
import by.academy.it.task01.fileworker.FileWorkerException;
import by.academy.it.task01.fileworker.TextFileWorker;
import by.academy.it.task01.service.TextParser;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

/**
 * Create a java application that will read data from a source
 * ("in.txt" file) and sort them. The data has a tabular structure.
 * Lines are separated by line breaks. Columns - a tab character.
 * The data must be sorted and output to the "out.txt" file.
 * Sorting is done first by the first column of rows, then by the second
 * (if the strings or numbers in the first column match), etc.. Data
 * related to the same line in the grid must also be on the same line.
 * In this case: any number in the column is higher than any non-number, number
 * sorted in ascending order, strings in lexicographic order.
 *
 * Создайте jаvа-приложение, которое будет считывать данные из источника
 * (файл in.txt) и выполнять их сортировку. Данные имеют табличную структуру.
 * Строки разделены переносом строки. Столбцы - знаком табуляции.
 * Данные необходимо отсортировать и вывести в файл out.txt.
 * Сортировка производится сначала по первой колонке строк, потом по второй
 * (если строки или числа в первой колонке совпадают) и т.д .. Данные
 * относящиеся к одной строке в гриде должны быть также в одной строке.
 * При этом: любое число в колонке выше любого не числа, числа
 * отсортированы по возрастанию, строки в лексикографическом порядке.
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {

    public static void main(String[] args) {

        File file = new File("src/main/resources/in.txt");
        FileWorker<String> fileWorker = new TextFileWorker();
        Collection<String> strings = null;
        try {
            strings = fileWorker.readCollection(file);
        } catch (FileWorkerException e) {
            e.printStackTrace();
        }

        strings.forEach(System.out::println);

        Collection<String[]> collection = TextParser.parseSentencetoAllWord(strings);
        for (String[] strings1 : collection) {
            System.out.println(strings1.length);
            for (String s : strings1) {
                System.out.print(s + "-");
            }
            System.out.println();
        }

    }
}
