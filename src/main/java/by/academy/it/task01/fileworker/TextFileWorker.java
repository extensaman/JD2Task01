package by.academy.it.task01.fileworker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TextFileWorker implements FileWorker<String> {

    public static final String TAB_SYMBOL = "\t";

    @Override
    public Collection<String> readCollection(File file) throws FileWorkerException {
        Collection<String> collection = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                collection.add(reader.readLine().strip());
            }
        } catch (IOException e) {
            throw new FileWorkerException(e);
        }
        return collection;
    }

    @Override
    public void writeCollection(File file, Collection<String[]> collection) throws FileWorkerException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String[] line : collection) {
                for (String word : line) {
                    writer.write(word.concat(TAB_SYMBOL));
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new FileWorkerException(e);
        }
    }
}
