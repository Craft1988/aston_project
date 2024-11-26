package sorter.project.utils;

public final class Validation {
    private Validation() {
        throw new UnsupportedOperationException();
    }

    public static boolean generalValidation(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        String[] value = line.split(" ");
        if (value.length > 3) {
            return false;
        }
        return true;
//        int first;
//        if (line.contains(" ")) {
//            first = line.indexOf(" ");
//        } else return false;
//        int second = line.indexOf(" ", first);
//        return line.indexOf(' ', second) != -1;
    }

    public static boolean animalValidation(String line) {
        String[] value = line.split(" ");
        if (Character.isUpperCase(value[0].charAt(0)) && value.length == 1) {
            return true;
        }
        if ((value.length >= 2) && (value[1].equals("true") || value[1].equals("false")) && Character.isUpperCase(value[0].charAt(0))) {
            return true;
        }

//        int first = line.indexOf(" ");
//        int second = line.indexOf(" ", first + 1);
//        if (Character.isUpperCase(line.charAt(0)) && Character.isUpperCase(line.charAt(second + 1))) {
//            return line.substring(first + 1, second)
//                    .equals("true") || line.substring(first + 1, second).equals("false");
//        }
        return false;

    }

    public static boolean manValidation(String line) {
        String[] value = line.split(" ");
        if (!Character.isUpperCase(value[0].charAt(0))) {
            return false;
        }
        if (value.length >= 2) {
            String ageStr = value[1].trim();
            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0 || age > 120) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
            if (value.length == 3) {
                String gender = value[2].trim();
                if (!gender.equals("man") && !gender.equals("woman")) {
                    return false;
                }
            }

        }


        return true;
//        int first = line.indexOf(" ");
//        if (first == -1) {
//            return false;
//        }
//        int second = line.indexOf(" ", first + 1);
//        if (second == -1) {
//            return false;
//        }
//        if (!Character.isUpperCase(line.charAt(0))) {
//            return false;
//        }
//        String gender = line.substring(second + 1).trim();
//        if (!gender.equals("man") && !gender.equals("woman")) {
//            return false;
//        }
//        String ageStr = line.substring(first + 1, second).trim();
//        int age;
//        try {
//            age = Integer.parseInt(ageStr);
//            if (age < 0 || age > 120) {
//                return false;
//            }
//        } catch (NumberFormatException e) {
//            return false;
//        }
//
//        return true;
    }


    public static boolean barrelValidation(String line) {
        String[] value = line.split(" ");
        boolean n = false;
        int indexOfPoint = value[0].indexOf('.');
        try {
            String volumeStr = value[0].trim();
            float volume = Float.parseFloat(volumeStr);
            if (volume < 0) {
                return false;
            }

            for (int i = 0; i < value[0].length(); i++) {
                if (i == indexOfPoint) continue;
                if (Character.isDigit(value[0].charAt(i))) {
                    n = true;
                } else {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return n;
    }
}

//        int first = line.indexOf(" ");
//        int second = line.indexOf(" ", first + 1);
//
//        if (first == -1 || second == -1) {
//            return false;
//        }
//        if (Character.isUpperCase(line.charAt(first + 1)) && Character.isUpperCase(line.charAt(second + 1))) {
//            boolean n = false;
//            int indexOfPoint = line.indexOf('.', 0);
//
//            try {
//                String volumeStr = line.substring(0, first).replace(".", "").trim();
//                int volume = Integer.parseInt(volumeStr);
//                if (volume < 0) {
//                    return false;
//                }
//
//                for (int i = 0; i < first; i++) {
//                    if (i == indexOfPoint) continue;
//                    if (Character.isDigit(line.charAt(i))) {
//                        n = true;
//                    } else {
//                        return false;
//                    }
//                }
//            } catch (NumberFormatException e) {
//                return false;
//            }
//
//            return n;
//        }
//
//        return false;
//    }
