package by.academy.it.task01.fileworker;

import java.io.File;
import java.util.Collection;

public class TextFileWorker implements FileWorker<String[]>{

    @Override
    public Collection<String[]> readCollection(File file) {
        return null;
    }

    @Override
    public void writeCollection(File file, Collection<String[]> collection) {

    }
}
