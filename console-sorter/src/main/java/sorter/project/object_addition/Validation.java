package sorter.project.object_addition;

import sorter.project.entity.Animal;

import static java.lang.Integer.*;

public final class Validation {
    private Validation() {
        throw new UnsupportedOperationException();
    }

    public static boolean generalValidation(String line) {
        int first;
        if (line.indexOf(" ") != -1) {
            first = line.indexOf(" ");
        } else return false;
        int second = line.indexOf(" ", first);
        return line.indexOf(' ', second) != -1;
    }

    public static boolean animalValidation(String line) {
        int first = line.indexOf(" ");
        int second = line.indexOf(" ", first + 1);
        if (Character.isUpperCase(line.charAt(0)) && Character.isUpperCase(line.charAt(second + 1))) {
            return line.substring(first + 1, second).equals("true") || line.substring(first + 1, second).equals("false");
        }
        return false;
    }

    public static boolean manValidation(String line) {
        int first = line.indexOf(" ");
        int second = line.indexOf(" ", first + 1);
        if (Character.isUpperCase(line.charAt(0))) {
            if (line.substring(second + 1).equals("man") || line.substring(second + 1).equals("woman")) {
                boolean n = false;
                for (int i = first + 1; i < second; i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        n = true;
                    } else {
                        return false;
                    }
                }
                return n;
            }
        }
        return false;
    }

    public static boolean barrelValidation(String line) {
        int first = line.indexOf(" ");
        int second = line.indexOf(" ", first + 1);
        if (Character.isUpperCase(line.charAt(first + 1)) && Character.isUpperCase(line.charAt(second + 1))) {
            boolean n = false;
            int indexOfPoint;
            if (line.indexOf(".", 0 /*,first*/) != -1) {
                indexOfPoint = line.indexOf('.', 0/*, first*/);
                for (int i = 0; i < first; i++) {
                    if (i == indexOfPoint) continue;
                    if (Character.isDigit(line.charAt(i))) {
                        n = true;
                    } else {
                        return false;
                    }
                }
            }
            return n;
        }
        return false;
    }
}
