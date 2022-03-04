package by.academy.it.task01.fileworker;

import java.io.File;
import java.util.Collection;

public interface FileWorker<T> {
    Collection<T> readCollection(File file);
    void writeCollection(File file, Collection<T> collection);
}
