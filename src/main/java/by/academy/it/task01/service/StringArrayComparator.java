package by.academy.it.task01.service;

import java.util.Comparator;

public class StringArrayComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] array1, String[] array2) {
        int minArrayLength = Integer.min(array1.length, array2.length);
        int result = 0;

        for (int i = 0; i < minArrayLength; i++) {
            boolean element1IsNumber = isNumber(array1[i]);
            boolean element2IsNumber = isNumber(array2[i]);

            if (element1IsNumber && element2IsNumber) {
                result = Double.compare(Double.parseDouble(array1[i]), Double.parseDouble(array2[i]));
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            }

            if (!element1IsNumber && !element2IsNumber) {
                result = array1[i].compareTo(array2[i]);
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            }

            if (element1IsNumber) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private boolean isNumber(String str) {
        try {
            Double.valueOf(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
