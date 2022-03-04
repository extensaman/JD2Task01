package by.academy.it.task01.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TextParser {

    public static final String DIVIDER_REGEX = "\\s+";

    private TextParser() {

    }

    public static Collection<String[]> parseSentencetoAllWord(Collection<String> strings) {
        return strings.stream()
                .map(line -> line.split(DIVIDER_REGEX))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
