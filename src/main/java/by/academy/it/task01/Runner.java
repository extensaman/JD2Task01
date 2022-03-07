package by.academy.it.task01;

import by.academy.it.task01.fileworker.FileWorker;
import by.academy.it.task01.fileworker.FileWorkerException;
import by.academy.it.task01.fileworker.TextFileWorker;
import by.academy.it.task01.service.StringArrayComparator;
import by.academy.it.task01.service.TextParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;

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
 * <p>
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
    public static final Logger LOGGER = Logger.getLogger("JD2Task01");
    public static final String INPUT_FILE_PATH = "src/main/resources/in.txt";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/out.txt";

    public static final String EXCEPTION_THROWS_WHILE_READING_FILE = "Exception throws while reading file ";
    public static final String TEXT_INPUT_FILE = "Input file ";
    public static final String IS_READ = " is read";
    public static final String PARSING_TO_COLLECTION_STRING_IS_DONE = "Parsing to Collection<String[]> is done";
    public static final String COLLECTION_STRING_IS_SORTED = "Collection<String[]> is sorted";
    public static final String EXCEPTION_THROWS_WHILE_WRITTING_FILE = "Exception throws while writting file ";
    public static final String OUTPUT_FILE = "Output file ";
    public static final String IS_WRITTEN = " is written";

    public static void main(String[] args) {

        File inputFile = new File(INPUT_FILE_PATH);
        FileWorker<String> fileWorker = new TextFileWorker();
        Collection<String> strings = null;
        try {
            strings = fileWorker.readCollection(inputFile);
        } catch (FileWorkerException e) {
            LOGGER.error(EXCEPTION_THROWS_WHILE_READING_FILE + inputFile, e);
            return;
        }
        LOGGER.trace(TEXT_INPUT_FILE + inputFile + IS_READ);

        Collection<String[]> collection = TextParser.parseSentencetoAllWord(strings);
        LOGGER.trace(PARSING_TO_COLLECTION_STRING_IS_DONE);

        Collection<String[]> sortedCollection = collection.stream()
                .sorted(new StringArrayComparator())
                .collect(Collectors.toList());
        LOGGER.trace(COLLECTION_STRING_IS_SORTED);

        File outputFile = new File(OUTPUT_FILE_PATH);
        try {
            fileWorker.writeCollection(outputFile, sortedCollection);
        } catch (FileWorkerException e) {
            LOGGER.error(EXCEPTION_THROWS_WHILE_WRITTING_FILE + outputFile, e);
            return;
        }
        LOGGER.trace(OUTPUT_FILE + outputFile + IS_WRITTEN);
    }
}
