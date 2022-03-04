package by.academy.it.task01.fileworker;

public class FileWorkerException extends Exception{
    public FileWorkerException() {
    }

    public FileWorkerException(String message) {
        super(message);
    }

    public FileWorkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWorkerException(Throwable cause) {
        super(cause);
    }
}
